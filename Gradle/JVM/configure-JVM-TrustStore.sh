#!/usr/bin/env bash
if [ "$POSIXLY_CORRECT" = "y" ]; then
  echo "This script is not designed for POSIX mode" >&2
  exit 1
fi

if [[ ! $BASH ]]; then
  echo "This script is designed for Bash only" >&2
  exit 1
fi

set -e
set -o pipefail

readonly SCRIPT_VER=3.0.0

# Remove the longest `*/` prefix
readonly SCRIPT_FULL_NAME="${0##*/}"

usage() {
  cat <<HEREDOC
NAME

    $SCRIPT_FULL_NAME -- install the NIH CA cert into JVM's TrustStore(s)

SYNOPSIS

    $SCRIPT_FULL_NAME [-f] [JAVA_Home_dir]
    $SCRIPT_FULL_NAME -h: display this help

DESCRIPTION

    NIH Certificate Authority is used on the NIH network, including VPN to automatically sign all valid website
    certificates. If this is not configured correctly in miscellaneous clients then HTTPS downloads on NIH network would
    fail.

    The following options are available:

    -f            force installation. By default, the script checks a presence of the cert alias in a JVM and skips
                  installation if found.

    JAVA_Home_dir install the cert into this JVM only. By default, the script installs the cert into TrustStores for the
                  following JVMs:

                  * System JVM

                  (Mac):
                  * All-users (\`/Applications/\`) JetBrains IntelliJ IDEA JVM, if present
                  * User-specific (\`~/Applications/\`) JetBrains IntelliJ IDEA JVM, if present
                  * All-users (\`/Applications/\`) JetBrains Rider JVM, if present
                  * User-specific (\`~/Applications/\`) JetBrains Rider JVM, if present

    Each previous Java TrustStore is backed up with a \`.bak\` extension.

ENVIRONMENT

    ## Required ##

    * Shell: Bash in non-POSIX (default) mode.

    * If the change is affecting a global (all-users) JVM, the script likely has to be run under \`sudo\` and \`sudo\`
    permissions will be required.

v$SCRIPT_VER
HEREDOC
  exit 1
}

########################################################################################################################
# Print basic info about the running script and parameters
#
# Arguments:
#   $@     Script arguments
#
# Globals:
#   $SCRIPT_VER
#
# v3.0.0
########################################################################################################################
hello() {
  local exec_sh
  if [[ -h /proc/$$/exe ]]; then # Does the file exist and is a symbolic link?
    # Linux. `ps` might not be available in some distributions, e.g., Docker base images.
    exec_sh=$(readlink --canonicalize /proc/$$/exe)
  else
    # Mac
    exec_sh=$(ps -p "$$" -o comm=)
  fi
  printf "[%s] Executing shell: " "$(date +'%F %T %Z')"
  if [[ "$exec_sh" == /* ]]; then
    echo "$exec_sh"
  else
    # Shell filename without the path: `script.sh` (= `/usr/bin/env bash script.sh`) or `shell script.sh` execution

    # Suffix after the first '-', if any. Login shell process names start with `-`, e.g. `-bash`.
    local -r EXEC_SH_NAME=${exec_sh#*-}

    which "$EXEC_SH_NAME"
  fi
  printf '%s@%s %s> %s [v%s]' "$(id -un)" "${HOSTNAME}" "${PWD}" "$0" "$SCRIPT_VER"
  if (($# > 0)); then
    printf ' '
    printf '"%s" ' "$@"
  fi
  printf '\n\n'
}

if [[ "$1" != "-h" ]]; then
  hello "$@"
fi

# If a character is followed by a colon, the option is expected to have an argument
while getopts fh OPT; do
  case "$OPT" in
    f)
      FORCE_MODE=true
      ;;
    *) # -h or `?`: an unknown option
      usage
      ;;
  esac
done
shift $((OPTIND - 1))

# Process positional parameters
SPECIFIC_JVM="$1"

install() {
  if [[ -x "$JAVA_HOME/bin/java" ]]; then
    echo "Installing certs into the Java TrustStore at $JAVA_HOME..."
    "$JAVA_HOME/bin/java" -version
  else
    echo -e "Java is not found at $JAVA_HOME\n"
    return
  fi

  if "$JAVA_HOME/bin/keytool" -cacerts -list -alias nih-dpki-root-1a -storepass changeit >/dev/null; then
    local CERT_ALREADY_INSTALLED=true
  fi

  if [[ $CERT_ALREADY_INSTALLED && ! $FORCE_MODE ]]; then
    echo "nih-dpki-root-1a cert is already in this TrustStore."
  else
    BACKUP_VER=$(date -r "$JAVA_HOME/lib/security/cacerts" '+%F@%H-%M-%S')
    cp -pv "$JAVA_HOME/lib/security/cacerts" "$JAVA_HOME/lib/security/cacerts-${BACKUP_VER}.bak"

    if [[ $CERT_ALREADY_INSTALLED ]]; then
      "$JAVA_HOME/bin/keytool" -cacerts -delete -alias nih-dpki-root-1a -storepass changeit -noprompt >/dev/null
    fi
    "$JAVA_HOME/bin/keytool" -cacerts -importcert -alias nih-dpki-root-1a -file NIH-DPKI-ROOT-1A.cer \
        -storepass changeit -noprompt
  fi
  echo
}

# Get a script directory, same as by $(dirname $0)
readonly SCRIPT_DIR=${0%/*}
cd "${SCRIPT_DIR}"

JAVA_HOME=${SPECIFIC_JVM:-$(echo 'System.out.println(System.getProperty("java.home"))' | jshell -)}
install

# (Mac)
if [[ "${OSTYPE}" == darwin* ]]; then
  JAVA_HOME='/Applications/IntelliJ IDEA.app/Contents/jbr/Contents/Home'
  install

  JAVA_HOME=~/Applications/IntelliJ\ IDEA.app/Contents/jbr/Contents/Home
  install

  JAVA_HOME='/Applications/Rider.app/Contents/jbr/Contents/Home'
  install

  JAVA_HOME=~/Applications/Rider.app/Contents/jbr/Contents/Home
  install
fi
