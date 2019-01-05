<template>
  <div>
    <div class="topSearch">
        <Input v-model="searchStr" placeholder="请输入宿舍编号查询" style="width: 800px"/>
        <Button  type="info" class="button"  @click="search">查询</Button>
          <Button type="info" class="button" @click="addUserInit">新增学生</Button>
    </div>

      <div id="id1">  

     <Table border ref="selection" :loading="loading" :columns="columns7" :data="dataList"></Table>
      <div style="margin: 10px;overflow: hidden">
        
        <div id="id2">
      <Button type="success" @click="handleSelectAll(true)">设置全选</Button>
       <Button type="success" @click="handleSelectAll(false)">取消全选</Button>
        <Button type="success" @click="handledeleteAll(true)">全部删除</Button>
     </div>
 </div>
    

     </div>
   <!-- 新增表单开始 -->
     <Modal v-model="modalShow"
            :title="title"
            @on-ok="add"
            @on-cancel="cancel">
        <Form :model="formRight" label-position="right" :label-width="100">
            <FormItem label="用户宿舍">
                <Input v-model="formRight.input1"/>
            </FormItem>
            <FormItem label="用户学号">
                <Input v-model="formRight.input2"/>
            </FormItem>
            <FormItem label="用户名称">
                <Input v-model="formRight.input3"/>
            </FormItem>
        </Form>  
    </Modal>
   <!-- 表单结束 -->
    <!-- 编辑表单开始 -->
     <Modal v-model="editmodalShow"
            :title="title"
            @on-cancel="cancel">
        <Form :model="editform" label-position="right" :label-width="100">
            <FormItem label="宿舍编号">
                <Input v-model="editform.input1"/>
            </FormItem>
            <FormItem label="用电量">
                <Input v-model="editform.input2"/>
            </FormItem>
            <FormItem label="余额">
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
                dataList:this.mockTableData1(),
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
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    }, {
                        title: '宿舍号',
                        key: 'number1'
                    },
                   {
                        title: '学号',
                        key: 'number'
                    },
                    {
                        title: '姓名',
                        key: 'name',
                    },
                     {
                        title: '班级',
                        key: 'class'
                    },
                    {
                        title: '用电量',
                        key: 'use'
                    },
                   
                    {
                        title: '余额',
                        key: 'remainder'
                    },
                    
                    {
                        title: '操作',
                        key: 'action',
                        width: 300,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                       type:"info",
                                        size: 'small',
                                        shape:"circle"
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
                                }, '查看用电量'),
                                h('Button', {
                                    props: {
                                        type:"info",
                                        size: 'small',
                                        shape:"circle"

                                    },
                                      
                                    on: {
                                        click: () => {
                                            this.remove(params.index)
                                            this.$Message.success('删除')
                                        }
                                    }
                                }, '删除学生'),
                                 
                            ]);
                        }
                    }
                ],
                data6: [
                    { number1: 609,
                       number: 1701,
                        name: '梁聪聪',
                         class:'软件173',
                         use:50,
                         remainder:20    
                    },
                    {  
                        number1: 607,
                         number: 1702,
                        name:'梁伟',
                        class:'软件173',
                         use:50,
                         remainder:30   
                    },
                    {
                        number1: 608,
                        number: 1703,
                        name: '梅意婕',
                        class:'软件173',
                         use:50,
                         remainder:40   
                    },
                    { 
                        number1: 610,
                        number: 1704,
                        name: '陈文艺',
                        class:'软件173',
                         use:50,
                         remainder:50   
                    },
                    { 
                        number1: 617,
                        number: 1705,
                        name: '白伟婷',
                        class:'软件173',
                         use:50,
                         remainder:60   
                       
                    },
                    {
                        number1: 627,
                        number: 1706,
                        name: '曾文君',
                        class:'软件173',
                         use:50,
                         remainder:70    
                       
                    },
                    {
                        number1: 517,
                        number: 1707,
                        name: 'Joe Black',
                        class:'软件173',
                         use:50,
                         remainder:80   
                    },
                    {
                        number1: 407,
                        number:1708,
                        name: 'Joe Black',
                        class:'软件173',
                         use:50,
                         remainder:90   
                    },
                    { 
                        number1: 207,
                        number: 1709,
                        name: 'Jim Green',
                         class:'软件173',
                         use:80,
                         remainder:20   
                    },
                    { 
                        number1: 307,
                        number: 1710,
                        name: 'Jim Green',
                         class:'软件173',
                         use:60,
                         remainder:10   
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
                this.title = '查看用电量'
                this.editmodalShow = true
                this.editform.input1=this.dataList[this.temp1].number1
                 this.editform.input2=this.dataList[this.temp1].use
                  this.editform.input3=this.dataList[this.temp1].remainder
            },
            remove (index) {
                this.data6.splice(index, 1);
            },
            search () {    
                if(this.searchStr.trim() !==""){
                    this.data6.forEach(element => { 
                      if(element.number1 == this.searchStr){
                          var index = this.data6.indexOf(element)
                           this.dataList = []
                          this.dataList.push(this.data6[index])
                        }
                    })
                }else{
                    this.dataList = this.data6
                }
                 
                } ,
               cancel(){
                this.modalShow = false
                this.editmodalShow = false
            },
            addUserInit() {
                this.title = '新增用户'
                this.modalShow = true
            },
            add(){              
                var temp =  {
                        number1: this.formRight.input1,
                        number: this.formRight.input2,
                        name: this.formRight.input3
                    }
                this.dataList.push(temp)  
                this.$Message.success('新增成功')
            },
               handleSelectAll (status) {
               this.$refs.selection.selectAll(status);
               //this.data6.splice(status);
            },
           handledeleteAll()
            {
                this.data6.splice(status);
            },
             changePage () {
                // The simulated data is changed directly here, and the actual usage scenario should fetch the data from the server
                this.dataList=this.mockTableData1();
                this.remove=this.mockremove;
                this.search=this.mocksearch
            },
            mockremove (index) {
                this.mockTableData1.splice(index, 1);
            },
            mocksearch () {    
                if(this.searchStr.trim() !==""){
                    this.mockTableData1.forEach(element => { 
                      if(element.name == this.searchStr){
                          var index = this.mockTableData1.indexOf(element)
                           this.dataList = []
                          this.dataList.push(this.mockTableData1[index])
                        }
                    })
                }else {
                 this.dataList = this.mockTableData1
                } 
                 
            },
            mockTableData1()
            {
            let data = [];
                for (let i = 0; i < 10; i++) {
                    data.push({
                        number: Math.floor(Math.random () * 3 + 1), 
                        name: '姓名' + Math.floor(Math.random () * 100 + 1),
                         age:Math.floor(Math.random () * 7 + 1),
                        update: new Date()
                    })
                }
                return data;
            },
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
            margin-left: -280px;
        }
        .button{
            margin-left: 10px;
        }
       #id1 {
           position: relative;
       }
       #id2 {
           margin-top: 0px;
           float: left;
           
       }

    </style>
