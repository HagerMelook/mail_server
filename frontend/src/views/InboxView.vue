<template>
  <custompage v-if="done" :emails="inbox" v-on:handledelete="handledelete" :inbox="true" :sent="false"></custompage>
</template>
<script>
import custompage from '../components/custompage.vue'
import axios from 'axios'

export default {
  data() {
    return {
      done: false,
      inbox: [],
      id: this.$route.params.id,
    }
  },
  components: {
    custompage
  },
  methods: {
    handledelete(group) {
      for(let i in group){  
        axios.delete('http://localhost:8080/' + this.id + '/inbox/delete/' +i,
        
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
    const data = {
      userId: Number.toString(this.id),
      sortingKeyword: "importance",
    }
    axios.post('http://localhost:8080/sort', data,
      {
        headers: {
          "Content-Type": 'application/json'
        }
      }
    )
      .then((respond) => {
        console.log(respond.data);
        this.inbox = respond.data;
        this.done = true


      })
      .catch((error) => {
        console.log(error)
      });

  }
}
</script>