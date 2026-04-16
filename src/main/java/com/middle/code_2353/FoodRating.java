package com.middle.code_2353;

import java.util.*;

/**
 * @Author chenyuxiang
 * @Date 2025/2/28
 * @Description
 */
class FoodRatings {
    // 每个食物对应的 (菜系, rating)
    private Map<String, String> foodToCuisine = new HashMap<>();
    private Map<String, Integer> foodToRating = new HashMap<>();

    // 每个菜系对应一个 TreeSet
    private Map<String, TreeSet<Food>> cuisineToFoods = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];

            foodToCuisine.put(f, c);
            foodToRating.put(f, r);

            // 初始化
            cuisineToFoods.putIfAbsent(c, new TreeSet<>());
            cuisineToFoods.get(c).add(new Food(f, r));
        }
    }

    public void changeRating(String food, int newRating) {
        String c = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        // 1. 从 tree set 中删除老对象
        cuisineToFoods.get(c).remove(new Food(food, oldRating));

        // 2. 更新 rating
        foodToRating.put(food, newRating);

        // 3. 插入新对象
        cuisineToFoods.get(c).add(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        // 直接拿 TreeSet 的第一个元素
        return cuisineToFoods.get(cuisine).first().name;
    }


    // Food类
    static class Food implements Comparable<Food> {
        String name;
        int rating;
        public Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food other) {
            // rating降序
            // 如果 rating 相同，按名称升序
            if (this.rating != other.rating) {
                return Integer.compare(other.rating, this.rating);
            }
            // 名称升序
            return this.name.compareTo(other.name);
        }

        // 需要重写equals和hashCode，才能在remove时找到正确对象
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Food other = (Food) o;
            return rating == other.rating && Objects.equals(name, other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, rating);
        }
    }
}
