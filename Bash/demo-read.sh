#!/usr/bin/env bash
# xpg_echo: the echo builtin expands backslash-escape sequences by default
shopt -u xpg_echo

echo -e "## Reading $0 ##"
echo "------"
while IFS= read -r line; do
  echo "${line}"
done <"$0"
echo "------"

echo -e "\n## Reading from the pipe ##"
echo "------"
cat "$0" | while IFS= read -r line; do
  echo "${line}"
done
echo "------"

echo -e "\n## Reading from a here string ##"
echo "------"
while IFS=$'|\r' read -r field1 field2; do
  echo "f1='${field1}' f2='${field2}'"
done <<< $'000256438300024|WO2012161841
000256438300024|WO2013167147
000256438300030|WO2009152374
000256449600017|EP2500926
000256303500008|WO2014018776
A1993LL84500001|US6004747-A
A1993LL84500001|WO9500664-A
A1993LL84500001|WO9500664-A1
A1992JH17200008|US6004747-A
A1992JH17200008|WO9500664-A'
echo "------"

echo -e "\n## Reading from a Windows input (with CRLF newlines) ##"
echo "------"
while IFS=$',\r' read -r field1 field2; do
  echo "f1='${field1}' f2='${field2}'" | xxd
done <<< $'1,2\r
3,4\r'
echo "------"

echo -e "\n## Parsing the input ##"
echo "wos_id,country,patent_id,patent_type"
{ cat <<'HEREDOC'
000256438300024|WO2012161841
000256438300024|WO2013167147
000256438300030|WO2009152374
000256449600017|EP2500926
000256303500008|WO2014018776
A1993LL84500001|US6004747-A
A1993LL84500001|WO9500664-A
A1993LL84500001|WO9500664-A1
A1992JH17200008|US6004747-A
A1992JH17200008|WO9500664-A
HEREDOC
} | while IFS='|' read -r wos_id full_patent_num; do
  # Read an array and ignore backslashes
  IFS='-' read -ra patent_parts <<< "${full_patent_num:2}"
  echo "${wos_id},${full_patent_num:0:2},${patent_parts[0]},${patent_parts[1]}"
done | cat