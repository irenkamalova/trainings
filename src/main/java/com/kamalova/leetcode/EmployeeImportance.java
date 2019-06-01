package com.kamalova.leetcode;

import java.util.*;

/*

Success
Details 
Runtime: 5 ms, faster than 98.44% of Java online submissions for Employee Importance.
Memory Usage: 47.1 MB, less than 95.97% of Java online submissions for Employee Importance.

*/

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        int importance = 0;
        
        LinkedList<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while (!queue.isEmpty()) {
            Employee emp = queue.removeFirst();
            importance += emp.importance;
            List<Integer> l = emp.subordinates;
            for (Integer sub : l) {
                queue.add(map.get(sub));
            }
        }
        return importance;
    }
    
}
