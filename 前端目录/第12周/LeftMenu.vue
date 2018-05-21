<template>
          <Sider :style="{position: 'fixed', height: '100vh', left: 0, overflow: 'auto'}">
            <Menu active-name="1-2" theme="dark" width="auto" :open-names="['1']">
                <Submenu name="1">
                    <template slot="title">
                        <Icon type="ios-navigate"></Icon>
                        主页
                    </template>
                    <router-link to="onesmall"><MenuItem name="1-1">学校基本情况</MenuItem></router-link>
                    <MenuItem name="1-2">专业课程安排</MenuItem>
                    <MenuItem name="1-3">网络教学平台</MenuItem>
                </Submenu>
                <Submenu name="2">
                    <template slot="title">
                       <Icon type="ios-keypad"></Icon>
                        学生基本信息
                    </template>
                 <router-link to="test1"><MenuItem name="2-1">姓名及性别及年龄</MenuItem></router-link>
                    <router-link to="test2"><MenuItem name="2-2">学号及专业及班级</MenuItem></router-link>
                </Submenu>
                <Submenu name="3">
                    <template slot="title">
                        <Icon type="ios-analytics"></Icon>
                        学生成绩查询
                    </template>
                    <MenuItem name="3-1">单科成绩概况</MenuItem>
                    <MenuItem name="3-2">加权成绩及学校排名</MenuItem>
                </Submenu>
            </Menu>
        </Sider>
</template>
