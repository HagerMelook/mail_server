<template>
  <custompage v-if="done" :emails="folder"></custompage>
</template>
<script>
import custompage from '../components/custompage.vue'
import axios from 'axios'

export default {
  data() {
    return {
      done:false,
      folder: [],
      id: this.$route.params.id,
      folderName: this.$route.params.folderName,
      
    }
  },
  components: {
    custompage
  },
 
   beforeMount() {
    axios.get('http://localhost:8080/' +this.id +'/userFolders/'+this.folderName,
      )
        .then((respond) => {
          console.log(respond.data);
          this.folder=respond.data;
          this.done=true

        })
        .catch((error) => {
          console.log(error)
        });
   }

}
</script>