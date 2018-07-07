<template>
  <div>
    <div class="topSearch">
        <Input v-model="searchStr" placeholder="请输入名字或者编号查询" style="width: 800px"/>
        <Button  type="info" class="button"  @click="search">查询</Button>
        <Button type="info" class="button" @click="addUserInit">新增</Button>
    </div>
    <Table border :loading="loading" :columns="columns7" :data="dataList"/>

   <!-- 表单开始 -->
     <Modal v-model="modalShow"
            :title="title"
            @on-ok="add"
            @on-cancel="取消">
        <Form :model="formRight" label-position="right" :label-width="100">
            <FormItem label="用户ID">
                <Input v-model="formRight.input1"/>
            </FormItem>
            <FormItem label="用户名称">
                <Input v-model="formRight.input2"/>
            </FormItem>
            <FormItem label="年龄">
                <Input v-model="formRight.input3"/>
            </FormItem>
        </Form>  
    </Modal>
   <!-- 表单结束 -->

  </div>
  
</template>
<script>
    export default {
        data () {
            return {
                title:'',
                modalShow: false,
                formRight: {
                    input1: '',
                    input2: '',
                    input3: ''
                },
                searchStr: '',
                loading: true,
                dataList:[],
                columns7: [
                    {
                        title: 'Name',
                        key: 'name',
                        render: (h, params) => {
                            return h('div', [
                                h('Icon', {
                                    props: {
                                        type: 'person'
                                    }
                                }),
                                h('strong', params.row.name)
                            ]);
                        }
                    },
                    {
                        title: 'Age',
                        key: 'age'
                    },
                    {
                        title: 'Address',
                        key: 'address'
                    },
                    {
                        title: 'Action',
                        key: 'action',
                        width: 150,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.edit(params.index)
                                             
                                        }
                                    }
                                }, '编辑'),
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.remove(params.index)
                                            this.$Message.success('删除成功！')
                                        }
                                    }
                                }, '删除'),
                                 
                            ]);
                        }
                    }
                ],
                data6: [
                    {
                        name: '梁聪聪',
                        age: 18,
                        address: 'New York No. 1 Lake Park'
                    },
                    {
                        name: '梁伟',
                        age: 24,
                        address: 'London No. 1 Lake Park'
                    },
                    {
                        name: '李小龙',
                        age: 30,
                        address: 'Sydney No. 1 Lake Park'
                    },
                    {
                        name: '小生',
                        age: 26,
                        address: 'Ottawa No. 2 Lake Park'
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 'Sydney No. 1 Lake Park'
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 'Sydney No. 1 Lake Park'
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 'Sydney No. 1 Lake Park'
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 'Sydney No. 1 Lake Park'
                    },
                    {
                        name: 'Jim Green',
                        age: 24,
                        address: 'London No. 1 Lake Park'
                    },
                    {
                        name: 'Jim Green',
                        age: 24,
                        address: 'London No. 1 Lake Park'
                    },
                ]
            }
        },
        mounted (){ // 加载中事件
            // 定时关闭缓冲标志（1.5秒后）
            setTimeout(()=>{
                this.loading = false
                this.dataList = this.data6
            },1500)
        },
        methods: {
            edit (index) {
                this.$Modal.info({
                    title: 'User Info',
                    content: `Name：<br>Age：<br>Address：`
                })
            },
            remove (index) {
                this.data6.splice(index, 1);
            },
            search () {    
                if(this.searchStr.trim() !==""){
                    this.data6.forEach(element => { 
                        if(element.name == this.searchStr){
                            var index = this.data6.indexOf(element)
                            this.dataList = []
                            this.dataList.push(this.data6[index]) 
                        }
                    })
                }else {
                    this.dataList = this.data6
                 }
                
            },
            addUserInit() {
                this.title = '新增用户'
                this.modalShow = true
            },
            add(){
                var temp =  {
                        address: this.formRight.input1,
                        name: this.formRight.input2,
                        age: this.formRight.input3
                    }
                this.dataList.push(temp)  
                this.$Message.success('新增成功')
            }
        }
    }
</script>
<style type="text/css">
         table tr td{
            text-align: center;
         }
        .btn-info{
            margin-left: 5px;
        }

        .add,.addBox{
            margin: 10px 0px 10px 10px;
        }
        .submit{
            margin-left: 172px;
        }
        /*全删*/
        .delAll{
            margin-left: 10px;
        }
        /*新增*/
        fieldset{
            margin-left: 10px;
        }
        .topSearch{
            margin-bottom: 10px;
        }
        .button{
            margin-left: 10px;
        }
    </style>
