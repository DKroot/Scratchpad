# You are given two non-empty linked lists representing two non-negative integers.
# The digits are stored in reverse order and each of their nodes contain a single digit.
# Add the two numbers and return it as a linked list.
#
# You may assume the two numbers do not contain any leading zero, except the number 0 itself.
#
# Example:
#
# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: 7 -> 0 -> 8
# Explanation: 342 + 465 = 807.

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

    @classmethod
    def from_seq(cls, seq):
        """
        :type seq: Sequence
        """
        result = cls(0)
        cur = result
        first = True
        for el in seq:
            if not first:
                cur.next = cls(0)
                cur = cur.next
            cur.val = el
            first = False
        return result

    def out(self):
        cur = self
        while True:
            print(cur.val, end=' ')
            cur = cur.next
            if cur is None:
                break
            print('->', end=' ')


class Solution(object):
    @staticmethod
    def add_two_numbers(l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        result = ListNode(0)
        cur_result = result
        cur1 = l1
        cur2 = l2
        while True:
            cur_result.val += (cur1.val if cur1 is not None else 0) + (cur2.val if cur2 is not None else 0)
            if cur_result.val >= 10:
                carry_over = 1
                cur_result.val -= 10
            else:
                carry_over = 0
            if cur1 is not None:
                cur1 = cur1.next
            if cur2 is not None:
                cur2 = cur2.next
            if cur1 is None and cur2 is None:
                if carry_over > 0:
                    cur_result.next = ListNode(carry_over)
                break
            cur_result.next = ListNode(carry_over)
            cur_result = cur_result.next
        return result


if __name__ == '__main__':
    print("1 + 2 =", end=' ')
    Solution.add_two_numbers(ListNode(1), ListNode(2)).out()
    print('')

    print("342 + 465 =", end=' ')
    Solution.add_two_numbers(ListNode.from_seq([2, 4, 3]), ListNode.from_seq([5, 6, 4])).out()
    print('')

    print("19 + 9 =", end=' ')
    Solution.add_two_numbers(ListNode.from_seq([9, 1]), ListNode(9)).out()
    print('')

    print("8 + 42 =", end=' ')
    Solution.add_two_numbers(ListNode(8), ListNode.from_seq([2, 4])).out()
    print('')

    print("5 + 5 =", end=' ')
    Solution.add_two_numbers(ListNode(5), ListNode(5)).out()
    print('')
