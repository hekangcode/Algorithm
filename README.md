# Algorithm
常见基础算法，长期更新(欢迎指正)

一：算法题

1、已知整数n，用java实现函数f(n)，输出从1到n的字符串，以空格为分隔符。（见源码Test01.java）

2、输出一个字符串中连续出现次数最多的子字符串。输出一个字符串中连续出现次数最多的字符。（见源码Test02.java）

3、10万个用户，随机选出2017个幸运用户。（见源码Test03.java）

4、单链表删除倒数第N个节点。（见源码Test04.java）

   示意图

 ![](https://github.com/hekangcode/Algorithm/blob/master/app/src/main/res/drawable/test04.png)

5、有一个 int[] numbers 数组，指定一个数target，在这个数组中找出两个下标（N1 > 0,N2 > N1）,使得 numbers[N1] + numbers[N2] == target.（见源码Test05.java）

6、在上一题基础上，如果numbers里是个升序，用什么方法（用二分查找），二分查找的时间复杂度是多少（见源码Test05.java）

7、用数组实现在一个队列，大小固定，时间复杂度为n,我写的是有length的情况，然后他让在不使用length的情况下，实现。（见源码Test07.java）

8、判断两个链表是否相交，如果相交找出两个链表的相交点。（见源码Test08.java）

      带环的情况

      无非两种情况，一种是交于环外，一种交于环内

   这里写图片描述

![](https://github.com/hekangcode/Algorithm/blob/master/app/src/main/res/drawable/test0801.png)

这里写图片描述

![](https://github.com/hekangcode/Algorithm/blob/master/app/src/main/res/drawable/test0802.png)

    通过上图发现如果交于环内，出现了2个相交点，这只是视觉上的2个，其实如果把环看成链表1的，则就可以说链表2相交于链表1的B处；反过来，如果把环看成链表2的，则就可以说链表1相交于链表2的A处。所以我们求相交点时这里就默认输出B,你也可以根据需要自行都输出来。相交于环内和环外求相交点方法是不一样的，那么问题来了如何判断相交于环内还是环外？
    思路：

     1.首先获取到2个链表的长度，获得长度差L（因为环是共用的，所以这个差其实就是环外的差），获得2个链表的各个环入口点

     2.先让一个长的链表从头开始走过L个节点。

     3.再让短的链表从头与之同步后移，再保证2者不走到环入口的同时判断节点地址信息是否相同

     4.若相同并未到环入口点，则相交于环外，返回相交点。

9、有一个二叉树，让它打印1　2　3　4　5　6　7　，其实就是个广度优先
         
                   1
             2           3
        4       5   6       7
   －－－－－－－－－－－－－－－－

10、2000万个整数，找出第五十大的数字？

11、二叉树的深度优先遍历和广度优先遍历的具体实现。

12、数组排序算法

13、找数组中第k大的数字

14、找两个有序数组的中位数

15、反转链表

16、链表元素排序

17、合并两个有序链表

18、判断链表是否有环、有环的话环的起点在哪里（见源码Test08.java）

19、判断二叉树是否是平衡二叉树

20、判断二叉树是否相同

21、判断二叉树是否对称

22、如何用两个栈来实现一个队列

23、利用一个辅助栈来将一个栈中的元素排序

24、使用java实现一个栈（见源码StackTest.java）

