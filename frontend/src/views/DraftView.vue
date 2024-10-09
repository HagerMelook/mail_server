<template>
  <custompage  v-if="done" :emails="draft" v-on:handledelete="handledelete"></custompage>
</template>
<script>
import custompage from '../components/custompage.vue'
import axios from 'axios'

export default {
  data() {
    return {
      done:false,
      draft: [],
      id: this.$route.params.id,
    }
  },
  components: {
    custompage
  },
  methods: {
    handledelete(group) {
        axios.delete('http://localhost:8080/' + this.id + '/draft/delete/' +group[0],
        
          {
            headers: {
              "Content-Type": 'application/json'
            }
          }
        )
          .catch((error) => {
            console.log(error)
          });
    },
        sendmessage() {
            //api to save the message in inbox of the receiver and in the sent of sender
            const data = {
                receiver: this.email,
                subject: this.subject,
                text: this.text,
                importance:this.importance,
                sender:null

            }
            axios.post('http://localhost:8080/' +this.id +'/createEmail/send ',
                data,
                {
                    headers: {
                        "Content-Type": 'application/json'
                    }
                }
            )
                .then((respond) => {
                    console.log (respond.data);
                })
                .catch((error) => {
                     console.log(error)
                });
    }
  },
   beforeMount() {
    axios.get('http://localhost:8080/' + this.id + '/draft',
      )
        .then((respond) => {
          console.log(respond.data);
          this.draft=respond.data;
          this.done=true

        })
        .catch((error) => {
          console.log(error)
        });
   }
  
}
</script>