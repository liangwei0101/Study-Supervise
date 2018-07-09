<template>
  <div>
    <div class="topSearch">
        <Input v-model="searchStr" placeholder="请输入名字或者编号查询" style="width: 800px"/>
        <Button  type="info" class="button"  @click="search">查询</Button>
        <Button type="info" class="button" @click="addUserInit">新增</Button>
    </div>
    <Table border :loading="loading" :columns="columns7" :data="dataList"/>

   <!-- 新增表单开始 -->
     <Modal v-model="modalShow"
            :title="title"
            @on-ok="add"
            @on-cancel="cancel">
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
    <!-- 编辑表单开始 -->
     <Modal v-model="editmodalShow"
            :title="title"
            @on-ok="editit"
            @on-cancel="cancel">
        <Form :model="editform" label-position="right" :label-width="100">
            <FormItem label="用户ID">
                <Input v-model="editform.input1"/>
            </FormItem>
            <FormItem label="用户名称">
                <Input v-model="editform.input2"/>
            </FormItem>
            <FormItem label="年龄">
                <Input v-model="editform.input3"/>
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
                that: null,
                title:'',
                modalShow: false,
                editmodalShow : false,                    
                formRight: {
                    input1: '',
                    input2: '',
                    input3: ''
                },
                editform:{
                input1: '',
                input2: '',
                input3: '' 
                },
                temp1:'',
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
                                            this.temp1=params.index
                                            this.edit()                                        
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
                        address: 1
                    },
                    {
                        name: '梁伟',
                        age: 24,
                        address: 2
                    },
                    {
                        name: '曾文君',
                        age: 18,
                        address: 3
                    },
                    {
                        name: '小生',
                        age: 26,
                        address: 4
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 5
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 6
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 7
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 8
                    },
                    {
                        name: 'Jim Green',
                        age: 24,
                        address: 9
                    },
                    {
                        name: 'Jim Green',
                        age: 24,
                        address: 10
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
            edit () {
                this.title = '更改用户'
                this.editmodalShow = true
                this.editform.input1=this.dataList[this.temp1].address
                this.editform.input2=this.dataList[this.temp1].name
                this.editform.input3=this.dataList[this.temp1].age
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
            cancel(){
                this.modalShow = false
                this.editmodalShow = false
            },
            add(){              
                var temp =  {
                        address: this.formRight.input1,
                        name: this.formRight.input2,
                        age: this.formRight.input3
                    }
                this.dataList.push(temp)  
                this.$Message.success('新增成功')
            },
            editit(){      
               var temp =  {
                        address: this.editform.input1,
                        name: this.editform.input2,
                        age: this.editform.input3
                    }
                console.log(this.dataList[this.temp1])//打印
                this.dataList[this.temp1].address=temp.address
                this.dataList[this.temp1].name = temp.name
                this.dataList[this.temp1].age = temp.age            
                this.$Message.success('编辑成功')
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
