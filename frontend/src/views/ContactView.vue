<template>
  <custompage  v-if="done" :emails="contact" :contactview="true" v-on:handledelete="handledelete"></custompage>
</template>
<script>
import custompage from '../components/custompage.vue'
import axios from 'axios'

export default {
  data() {
    return {
      done: false,
      contact: [],
      id: this.$route.params.id,
    }
  },
  components: {
    custompage
  },
  methods: {
    getname(){
      axios.get('http://localhost:8080/' + this.id ,
    )
      .then((respond) => {
        return(respond.data) ;

      })
      .catch((error) => {
        console.log(error)
      });
    },
    handledelete(group) {
      group=group.sort()
      for(let  i=group.length-1 ; i>=0 ; i--){

        axios.delete('http://localhost:8080/' + this.id + '/contacts/delete/' +group[i],
        
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
    
    axios.get('http://localhost:8080/' + this.id + '/contacts',
    )
      .then((respond) => {
        this.contact = respond.data;
        this.done = true

      })
      .catch((error) => {
        console.log(error)
      });
  }

}
</script>