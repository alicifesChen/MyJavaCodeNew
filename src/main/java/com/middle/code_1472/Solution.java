package com.middle.code_1472;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2025/2/26
 * @Description
 */
public class Solution {
    class BrowserHistory {
        List<String> history;
        int cur;


        public BrowserHistory(String homepage) {
            this.history = new ArrayList<>();
            this.history.add(homepage);
            this.cur = 0;
        }

        public void visit(String url) {
            this.cur++;
            if (this.cur < this.history.size()) {
                this.history.set(this.cur, url);
                for (int i = this.history.size() - 1; i > this.cur; i--) {
                    this.history.remove(i);
                }
            } else {
                this.history.add(url);
            }
        }

        public String back(int steps) {
            this.cur = Math.max(0, this.cur - steps);
            return this.history.get(this.cur);
        }

        public String forward(int steps) {
            this.cur = Math.min(this.history.size() - 1, this.cur + steps);
            return this.history.get(this.cur);
        }
    }
}
