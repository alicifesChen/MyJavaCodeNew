package com.middle.code_2069;

/**
 * @Author chenyuxiang
 * @Date 2026-04-07
 * @Description 给你一个在 XY 平面上的 width x height 的网格图，左下角 的格子为 (0, 0) ，右上角 的格子为 (width - 1, height - 1) 。网格图中相邻格子为四个基本方向之一（"North"，"East"，"South" 和 "West"）。一个机器人 初始 在格子 (0, 0) ，方向为 "East" 。
 * 机器人可以根据指令移动指定的 步数 。每一步，它可以执行以下操作。
 * 沿着当前方向尝试 往前一步 。
 * 如果机器人下一步将到达的格子 超出了边界 ，机器人会 逆时针 转 90 度，然后再尝试往前一步。
 * 如果机器人完成了指令要求的移动步数，它将停止移动并等待下一个指令。
 * 请你实现 Robot 类：
 *
 * Robot(int width, int height) 初始化一个 width x height 的网格图，机器人初始在 (0, 0) ，方向朝 "East" 。
 * void step(int num) 给机器人下达前进 num 步的指令。
 * int[] getPos() 返回机器人当前所处的格子位置，用一个长度为 2 的数组 [x, y] 表示。
 * String getDir() 返回当前机器人的朝向，为 "North" ，"East" ，"South" 或者 "West" 。
 */
public class Solution {
    class Robot {
        int width;
        int height;

        int curWidth = 0;
        int curRight = 0;

        String dir = "East";

        public Robot(int width, int height) {
            this.height = height;
            this.width = width;
        }

        public void step(int num) {
            int perimeter = 2 * (width + height - 2);
            int restStep = num % perimeter;
            while (restStep > 0) {
                if(dir.equals("East")){
                    if(curRight < width - 1) {
                        curRight++;
                        restStep--;
                    } else {
                        dir = "North";
                    }
                } else if (dir.equals("North")) {
                    if(curWidth < height - 1) {
                        curWidth++;
                        restStep--;
                    } else {
                        dir = "West";
                    }
                } else if (dir.equals("West")) {
                    if(curRight > 0) {
                        curRight--;
                        restStep--;
                    } else {
                        dir = "South";
                    }
                } else {
                    if(curWidth > 0) {
                        curWidth--;
                        restStep--;
                    } else {
                        dir = "East";
                    }
                }
            }
        }

        public int[] getPos() {
            return new int[]{curRight, curWidth};
        }

        public String getDir() {
            return dir;
        }
    }

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
}
