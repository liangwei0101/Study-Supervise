<template>
  <div id="app">
      <upmenu/>
                <Layout :style="{padding: '0 24px 24px'}">
                    <Breadcrumb :style="{margin: '24px 0'}">
                        <BreadcrumbItem>Home</BreadcrumbItem>
                        <BreadcrumbItem>Components</BreadcrumbItem>
                        <BreadcrumbItem>Layout</BreadcrumbItem>
                    </Breadcrumb>
                    <leftmenu/>
                    <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
                      <router-view/>
                    </Content>
                </Layout>
  </div>
</template>

<script>
import upmenu from './components/upmenu.vue'
 import leftmenu from './components/leftmenu.vue'   
export default {
    components:{
    'upmenu':upmenu,
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

</style>
