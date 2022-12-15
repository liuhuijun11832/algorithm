package com.joy.string;

import java.util.LinkedList;
import java.util.Queue;

import com.joy.linkedlist.SinglyLinkedList.Node;

/**
 * AC自动机
 *
 * @author Joy
 * @date 2022-12-15
 */
public class ACAlgo {

    private AcNode root = new AcNode('/');


    public static class AcNode {
        public char data;
        public AcNode[] children = new AcNode[26]; // 字符集只包含a~z这26个字符
        public boolean isEndingChar = false; // 结尾字符为true
        public int length = -1; // 当isEndingChar=true时，记录模式串长度
        public AcNode fail; // 失败指针
        public AcNode(char data) {
            this.data = data;
        }
    }

    public void getFailurePointer(){
        // 用来递归每个节点
        Queue<AcNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < 26; i++) {
                // 拿到当前节点每个子节点
                AcNode pc = p.children[i];
                if (pc == null) {
                    continue;
                }
                // 如果p是root的话，子节点的失败指针指向上层也就是root
                if (p == root) {
                    pc.fail = root;
                }else{
                    // 拿到p的失败指针q
                    AcNode q = p.fail;
                    while (q != null) {
                        // 如果q的子节点字符和p的子节点字符相等，则字符串相等，p的子节点的失败节点指向q的子节点
                        AcNode qChildren = q.children[pc.data - 'a'];
                        if (qChildren != null) {
                            pc.fail = qChildren;
                            break;
                        }
                        // 否则q就不是最长公共前缀子串的尾结点，继续找下一个失败节点
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    public void match(char[] text){
        int n = text.length;
        AcNode p = root;
        for (int i = 0; i < n; i++) {
            int idx = text[i] - 'a';
            // 如果当前p的下一个字符和i不相等，则换一个模式串，指向另外一个完全匹配的模式串最后一个节点字符
            while (p.children[idx] == null && p != root) {
                p = p.fail;
            }
            // 如果都没找到，那么就从头开始匹配模式串
            p = p.children[idx];
            if (p == null) {
                p = root;
            }
            AcNode tmp = p;
            while (tmp != root) {
                // 该模式串能够完全匹配输入的主串
                if (tmp.isEndingChar) {
                    int pos = i - tmp.length + 1;
                    System.out.println("匹配到完整字符串，起始下标：" + pos + ";长度：" + tmp.length);
                }
                // 寻找下一个能够完全匹配的模式串
                tmp = tmp.fail;
            }
        }
    }

}
