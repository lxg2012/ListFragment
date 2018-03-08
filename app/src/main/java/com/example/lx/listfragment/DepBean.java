package com.example.lx.listfragment;

import java.util.ArrayList;

/**
 * Created by LX on 2017/12/22.
 */

public class DepBean {
    public ArrayList<DepChild> data;
    public String message;
    public int success;

    public class DepChild {
        /**
         *@child
         *child不要返回null
         */
        public ArrayList<DepChild> child;
        public String deptCode;
        public int deptLevel;
        public int deptName;
        public String parentCode;
    }
}
