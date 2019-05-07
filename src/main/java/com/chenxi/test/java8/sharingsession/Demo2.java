package com.chenxi.test.java8.sharingsession;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

public class Demo2 {
    public static void main(String[] args) {
        //价格日历
        List<PriceCalender> calenderList = Arrays.asList(
                new PriceCalender("2019-02-02", 20000),
                new PriceCalender("2019-02-03", 21000),
                new PriceCalender("2019-02-04", 22000)
        );

        //对流中每个元素应用函数
        List<String> departDates = calenderList.stream().map(PriceCalender::getDepartDate).collect(Collectors.toList());
        System.out.println("产品210598502支持的团期为" + String.join("，", departDates));

        //flatMap的效果是，各个数组并不是分别映射成一个流，而是映射成流的内容
        //让你把一个流中的每个值都换成另一个流，然后把所有的流连接起来称为一个流
        List<Department> departmentList = Arrays.asList(
                new Department("部门A", Arrays.asList("跟团游","自助游")),
                new Department("部门B", Arrays.asList("自驾游", "门票"))
        );

        List<String> bizList = departmentList.stream().flatMap(department -> department.getBizList().stream()).collect(Collectors.toList());
        System.out.println("所有业务：" + JSON.toJSONString(bizList));
    }
    /**
     * 价格日历
     */
    public static class PriceCalender {
        private String departDate;
        private double price;
        //other properties...

        public PriceCalender() {}

        public PriceCalender(String departDate, double price) {
            this.departDate = departDate;
            this.price = price;
        }

        public String getDepartDate() {
            return departDate;
        }

        public void setDepartDate(String departDate) {
            this.departDate = departDate;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public static class Department {
        private String name;
        private List<String> bizList;

        public Department() { }

        public Department(String name, List<String> bizList) {
            this.name = name;
            this.bizList = bizList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getBizList() {
            return bizList;
        }

        public void setBizList(List<String> bizList) {
            this.bizList = bizList;
        }
    }
}
