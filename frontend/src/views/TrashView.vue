<template>
  <custompage v-if="done" :emails="trash" v-on:handledelete="handledelete"></custompage>
</template>
<script>
import custompage from '../components/custompage.vue'
import axios from 'axios'

export default {
  data() {
    return {
      done:false,
      trash: [],
      id: this.$route.params.id,
    }
  },
  components: {
    custompage
  },
  methods: {
    handledelete(group) {
     
      for(let i in group){

        axios.delete('http://localhost:8080/' + this.id + '/trash/delete/' +i,
        
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
    axios.get('http://localhost:8080/' + this.id + '/trash',
      )
        .then((respond) => {
          console.log(respond.data);
          this.trash=respond.data;
          this.done=true

        })
        .catch((error) => {
          console.log(error)
        });
   }

}
</script>