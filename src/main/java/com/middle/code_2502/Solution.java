package com.middle.code_2502;

/**
 * @Author chenyuxiang
 * @Date 2025/2/25
 * @Description
 */
public class Solution {
    class Allocator {
        int[] memory;

        public Allocator(int n) {
            this.memory = new int[n];
            for (int i = 0; i < n; i++) {
                this.memory[i] = -1;
            }
        }

        public int allocate(int size, int mID) {
            for (int i = 0; i <= memory.length - size; i++) {
                // 看看从 i 开始的 size 个位置是否都为 -1
                boolean canAllocate = true;
                for (int j = i; j < i + size; j++) {
                    if (memory[j] != -1) {
                        canAllocate = false;
                        break;
                    }
                }
                if (canAllocate) {
                    // 分配
                    for (int j = i; j < i + size; j++) {
                        memory[j] = mID;
                    }
                    return i;  // 0-based
                }
            }
            return -1;  // 没有足够空间
        }


        public int freeMemory(int mID) {
            int count = 0;
            for (int i = 0; i < this.memory.length; i++) {
                if (this.memory[i] == mID) {
                    count++;
                    this.memory[i] = -1;
                }
            }
            return count;
        }
    }
}
