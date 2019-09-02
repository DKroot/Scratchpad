using System;
using System.Collections.Generic;
using System.Linq;
using NUnit.Framework;
using FluentAssertions;
using NUnit.Framework.Internal;

namespace LeetCodeOJ
{
    public class ListNode
    {
        public int val;

        public ListNode next;

        public ListNode(int x)
        {
            val = x;
        }
    }

    public class AddTwoNumbersSolution
    {
        public static ListNode Add(ListNode l1, ListNode l2)
        {
            ListNode result = null;
            ListNode lastNode = null;
            int carryOver = 0;
            do
            {
                var sumDigit = carryOver;
                if (l1 != null)
                {
                    sumDigit += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null)
                {
                    sumDigit += l2.val;
                    l2 = l2.next;
                }

                if (sumDigit < 10)
                {
                    carryOver = 0;
                }
                else
                {
                    sumDigit -= 10;
                    carryOver = 1;
                }

                var sumNode = new ListNode(sumDigit);
                if (lastNode != null)
                {
                    lastNode.next = sumNode;
                }
                lastNode = sumNode;
                if (result == null)
                {
                    result = lastNode;
                }
            } while (l1 != null || l2 != null || carryOver > 0);
            return result;
        }
    }

//[TestFixture]
//public class AddTwoNumbersTests
//{
//    [Test]
//    public void NumbersShouldAddUp()
//    {
//        AddTwoNumbers.Add(new List<byte> {2, 4, 3}, new List<byte> {5, 6, 4})
//            .Should()
//            .Equal(new List<byte> {7, 0, 8});

//        AddTwoNumbers.Add(new List<byte> {7, 3}, new List<byte> {5})
//            .Should()
//            .Equal(new List<byte> {2, 4});

//        AddTwoNumbers.Add(new List<byte> {9}, new List<byte> {3, 3})
//            .Should()
//            .Equal(new List<byte> {2, 4});
//    }

//    [Test]
//    public void NumbersShouldAddUpWithCarryOverPosition()
//    {
//        AddTwoNumbers.Add(new List<byte> {2, 9}, new List<byte> {9})
//            .Should()
//            .Equal(new List<byte> {1, 0, 1});
//    }

//    [Test]
//    public void ZeroShouldAddUp()
//    {
//        AddTwoNumbers.Add(new List<byte> {2, 4}, new List<byte> {0})
//            .Should()
//            .Equal(new List<byte> {2, 4});
//    }
//}
}