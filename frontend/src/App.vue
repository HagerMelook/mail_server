<template>
  <RouterView /> 
</template>
<script>
export default {
  name: 'App',
 
}
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  background-color: #f6f8fc;
}
body{
  margin: 0;
}
.viewcontainer {
  display: grid;
  grid-template-columns: 1fr 5fr;
  height: 100vh;
  width: 100%;
  margin: 0 0;
  border-top: 0;
}

</style>
