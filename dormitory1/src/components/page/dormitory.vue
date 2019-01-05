<template>
<div id="dmty1">
    <div class="input">
       宿舍编号：
         <Input v-model="searchStr" placeholder="请输入宿舍编号查询" style="width: 250px"/>
         <Button  type="info" class="button"  @click="search">查询</Button>
        <Button type="info" class="button" @click="addUserInit">新增</Button>
    </div>
    <div class="body">
        <Table border ref="selection" :columns="columns4" :data="dataList"></Table>
        <div id="bottomDiv">
        <Button type="success"  @click="handleSelectAll(true)">设置全选</Button>
        <Button type="success"  @click="handleSelectAll(false)">取消全选</Button>
         <Button type="success" @click="handledeleteAll(true)">全部删除</Button>
        </div>
    </div>
     <!-- 新增表单开始 -->
     <Modal v-model="modalShow"
            :title="title"
            @on-ok="add"
            @on-cancel="cancel">
        <Form :model="formRight" label-position="right" :label-width="100">
           >
            <FormItem label="宿舍编号">
                <Input v-model="formRight.input1"/>
            </FormItem>
            <FormItem label="宿舍楼宇">
                <Input v-model="formRight.input2"/>
            </FormItem>
             <FormItem label="宿舍楼层">
                <Input v-model="formRight.input3"/>
            </FormItem>
             <FormItem label="宿舍门牌">
                <Input v-model="formRight.input4"/>
            </FormItem>
             <FormItem label="容纳人数">
                <Input v-model="formRight.input5"/>
            </FormItem>
        </Form>  
    </Modal>
   <!--表单结束 -->
    <!-- 编辑表单开始 -->
     <Modal v-model="editmodalShow"
            :title="title"
            @on-ok="editit"
            @on-cancel="cancel">
        <Form :model="editform" label-position="right" :label-width="100">
          
            <FormItem label="宿舍编号">
                <Input v-model="editform.input1"/>
            </FormItem>
            <FormItem label="宿舍楼宇">
                <Input v-model="editform.input2"/>
            </FormItem>
            <FormItem label="宿舍楼层">
                <Input v-model="editform.input3"/>
            </FormItem>
            <FormItem label="宿舍门牌">
                <Input v-model="editform.input4"/>
            </FormItem>
            <FormItem label="容纳人数">
                <Input v-model="editform.input5"/>
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
                editmodalShow : false,                   
                formRight: {
                  
                    input1:'',
                    input2:'',
                    input3:'',
                    input4:'',
                    input5:''
                },
                editform:{
                input1:'',
                input2:'' ,
                input3:'',
                input4:'',
                input5:''
                },
                temp1:'',
                searchStr:'',
                loading: true,
                dataList:[],
                columns4: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                   
                    {
                        title: '宿舍编号',
                        key: 'number'
                    },
                    {
                        title: '宿舍楼宇',
                        key: 'dor1'
                    },
                     {
                        title: '宿舍楼层',
                        key: 'dor2'
                    },
                     {
                        title: '宿舍门牌',
                        key: 'dor3'
                    },
                     {
                        title: '容纳人数',
                        key: 'amount'
                    },
                      {
                        title: '操作',
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
                data1: [
                    { 
                       number: 'H608',
                       dor1: '和庐',
                       dor2: '六楼',
                       dor3:608,
                       amount:4
                    },
                    {
                       
                      
                       number: 'J509',
                       dor1: '静庐',
                       dor2: '五楼',
                       dor3:509,
                       amount:4
                    },
                    {
                      
                       
                       number: 'B309',
                       dor1: '北区四栋',
                       dor2: '三楼',
                       dor3:309,
                       amount:4
                    },
                    {
                       
                      
                       number: 'H601',
                       dor1:'和庐',
                       dor2: '六楼',
                       dor3:601,
                       amount:4
                    },
                   {
                       number: 'H604',
                       dor1:'和庐',
                       dor2: '六楼',
                       dor3:604,
                       amount:4
                    },
                    {
                      
                      
                     number: 'B302',
                       dor1: '北区四栋',
                       dor2: '三楼',
                       dor3:302,
                       amount:4
                    },
                    {
                      
                      
                      number: 'H602',
                       dor1: '和庐',
                       dor2: '六楼',
                       dor3:602,
                       amount:4
                    },
                    {
                       
                      
                       number: 'B202',
                       dor1: '北区四栋',
                       dor2: '二楼',
                       dor3:202,
                       amount:4
                    },
                    {
                      
                      
                        number: 'J519',
                       dor1: '静庐',
                       dor2: '五楼',
                       dor3:519,
                       amount:4
                    },
                    {
                       
                       number: 'J529',
                       dor1: '静庐',
                       dor2: '五楼',
                       dor3:529,
                       amount:4
                    }, 
                ]
            }
        },
         mounted (){ // 加载中事件
            // 定时关闭缓冲标志（1.5秒后）
            setTimeout(()=>{
                this.loading = false
                this.dataList = this.data1
            },1500)
          
        },
        methods: {
              
            remove (index) {
                this.data1.splice(index, 1);
            },
             search () { 
                if(this.searchStr.trim()!==""){
                    this.data1.forEach(element => {
                      if(element.number== this.searchStr){
                          var index = this.data1.indexOf(element)
                          this.dataList = []
                          this.dataList.push(this.data1[index])
                        }
                    })
                }else {
                 this.dataList = this.data1
                } 
                 
            },
            cancel(){
                this.modalShow = false
                this.editmodalShow = false
            },
            addUserInit() {
                this.title = '新增宿舍'
                this.modalShow = true
            },
            
            add(){              
                var temp =  {
                        number: this.formRight.input1,
                        dor1: this.formRight.input2,
                         dor2: this.formRight.input3,
                          dor3: this.formRight.input4,
                          amount:this.formRight.input5
                    }
                this.dataList.push(temp)  
                this.$Message.success('新增成功')
            },
             edit () {
                this.title = '更改宿舍信息'
                this.editmodalShow = true
                this.editform.input1=this.dataList[this.temp1].number
                this.editform.input2=this.dataList[this.temp1].dor1
                this.editform.input3=this.dataList[this.temp1].dor2
                this.editform.input4=this.dataList[this.temp1].dor3
                  this.editform.input5=this.dataList[this.temp1].amount
            },
            editit(){      
               var temp =  {
                        number: this.editform.input1,
                        dor1: this.editform.input2,
                         dor2: this.editform.input3,
                          dor3: this.editform.input4,
                          amount:this.editform.input5
                    }
                console.log(this.dataList[this.temp1])//打印
                
                this.dataList[this.temp1].number = temp.number
                this.dataList[this.temp1].dor1 = temp.dor1
                this.dataList[this.temp1].dor2 = temp.dor2
                this.dataList[this.temp1].dor3 = temp.dor3 
                this.dataList[this.temp1].amount= temp.amount          
                this.$Message.success('编辑成功')
               },
            handledeleteAll()
            {
                this.data1.splice(status);
            },
            handleSelectAll (status) {
                this.$refs.selection.selectAll(status);
            }
        }
    } 
</script>
<style scoped>
#dmty1{
    margin: 0px;
}
#bottomDiv{
    margin-top: 15px;
    float: left;
}
.input{
   float: left;
   margin-left: 20px;
}
.body{
    float: left;
    width: 100%;
    margin-top: 10px;
}
</style>

