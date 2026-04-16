package com.middle.code_690;

import java.util.List;

/**
 * @Author chenyuxiang
 * @Date 2024/8/26
 * @Description
 */
public class Solution {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    public int getImportance(List<Employee> employees, int id) {
        int res = 0;
        return findImportance(employees,id,res);
    }

    public int findImportance(List<Employee> employees, int id,int res) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                res += employee.importance;
                for (int i : employee.subordinates) {
                    res = findImportance(employees, i, res);
                }
            }
        }
        return res;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        List<Employee> employees = List.of(
//                new Employee(1, 5, List.of(2, 3)),
//                new Employee(2, 3, List.of()),
//                new Employee(3, 3, List.of())
//        );
//        int id = 1;
//        int res = solution.getImportance(employees, id);
//        System.out.println(res);
//    }
}
