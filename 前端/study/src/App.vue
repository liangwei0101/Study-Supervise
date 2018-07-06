<template>
  <div id="app">
    <div class="layout">
    <Layout>
      <upmenu/>
       <Layout>
         <leftmenu/>
                <Layout :style="{padding: '0 24px 24px'}">
                    <Breadcrumb :style="{margin: '24px 0'}">
                        <BreadcrumbItem>Home</BreadcrumbItem>
                        <BreadcrumbItem>Components</BreadcrumbItem>
                        <BreadcrumbItem>Layout</BreadcrumbItem>
                    </Breadcrumb>
                    <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
                      <router-view/>
                    </Content>
                </Layout>
       </Layout>
    </Layout>
    </div>
  </div>
</template>

<script>
import upmenu from '@/components/upmenu.vue'
import leftmenu from '@/components/leftmenu.vue'
export default {
   components:{
    'upmenu':upmenu ,
    'leftmenu':leftmenu
    } ,
  name: 'App'
 }
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
.layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
}
</style>
