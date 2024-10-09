<template>
  <custompage v-if="done" :emails="sent" v-on:handledelete="handledelete" :sent="true" :inbox="false"></custompage>
</template>
<script>
import custompage from '../components/custompage.vue'
import axios from 'axios';
export default {
  data() {
    return {
      done:false,
      sent: [],
      id: this.$route.params.id,
    }
  },
  components: {
    custompage
  },
  methods: {
    
    handledelete(group) {
      for(let  i in group){

        axios.delete('http://localhost:8080/' + this.id + '/sent/delete/'+ i,
        
          {
            headers: {
              "Content-Type": 'application/json'
            }
          }
        )
          .catch((error) => {
            console.log(error)
          });
      }
    }
  },
   beforeMount() {
    axios.get('http://localhost:8080/' + this.id + '/sent',
      )
        .then((respond) => {
          console.log(respond.data);
          this.sent=respond.data;
          this.done=true

        })
        .catch((error) => {
          console.log(error)
        });
   }
     //api to take folders

}
</script>