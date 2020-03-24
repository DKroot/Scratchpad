# Given a string, find the length of the longest substring without repeating characters.
#
# Example 1:
#
# Input: "abcabcbb"
# Output: 3
# Explanation: The answer is "abc", which the length is 3.
# Example 2:
#
# Input: "bbbbb"
# Output: 1
# Explanation: The answer is "b", with the length of 1.
# Example 3:
#
# Input: "pwwkew"
# Output: 3
# Explanation: The answer is "wke", with the length of 3.
#              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


class Solution(object):
    @staticmethod
    def length_of_longest_substring(s):
        """
        :type s: str
        :rtype: int
        """
        sub_str = ''
        max_len = 0
        for ch in s:
            pos = sub_str.find(ch)
            if pos == -1:
                sub_str += ch
            else:
                sub_str = sub_str[pos+1:] + ch
            if len(sub_str) > max_len:
                max_len = len(sub_str)
        return max_len


if __name__ == '__main__':
    # noinspection SpellCheckingInspection
    print("abcabcbb:", Solution.length_of_longest_substring("abcabcbb"))

    # noinspection SpellCheckingInspection
    print("bbbbb:", Solution.length_of_longest_substring("bbbbb"))

    # noinspection SpellCheckingInspection
    print("pwwkew:", Solution.length_of_longest_substring("pwwkew"))

    print("'':", Solution.length_of_longest_substring(""))

