<template>

<baidu-map class="map" :center="{lng: 115.863435, lat: 28.692497}" :zoom="12" :scroll-wheel-zoom="true">
<bm-map-type :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_LEFT"></bm-map-type>
<label>关键词：<input v-model="keyword"></label>
  <label>地区：<input v-model="location"></label>
  <bm-view class="map1" :center="{lng: 115.863435, lat: 28.692497}" :zoom="12" :scroll-wheel-zoom="true"></bm-view>

  <bm-bus :keyword="busKeyWord" :auto-viewport="true" :location="location"/>
  </baidu-map>
</template>

<script>
export default {
data () {
    return {
      location: '南昌',
      keyword: '百度',
      busKeyWord:'232'
    }
  }
}
</script>

<style>
.map {
  width: 100%;
  height: 600px;
}
.map1 {
  width: 100%;
  height: 400px;
}
</style>
