<template>
  <div>
    <Input v-model="value13" >
        <span slot="prepend">请输入名字或者编号查询</span>
        <Button @click="search" slot="append" icon="ios-search"/></Button>
    </Input>
    <Table border :loading="loading" :columns="columns7" :data="data6"></Table>
  </div>
</template>
<script>
    export default {
        data () {
            return {
                loading: true,
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
                                            this.show(params.index)
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
            },1500)
        },
        methods: {
            show (index) {
                this.$Modal.info({
                    title: 'User Info',
                    content: `Name：${this.data6[index].name}<br>Age：${this.data6[index].age}<br>Address：${this.data6[index].address}`
                })
            },
            remove (index) {
                this.data6.splice(index, 1);
            },
            search () {
                alert('我是测试')
            }
        }
    }
</script>
