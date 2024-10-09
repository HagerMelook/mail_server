<template>
    <div class="searchcontainer" v-on:change="handlesearch()">

    <div class="category">
        <div class="dropdown group">Category
            <div class="dropdown-content">
                <div class="option"  @click="category='inbox'">Inbox</div>
                <div class="option"  @click="category='trash'">Trash</div>
                <div class="option"  @click="category='send'">Sent</div>
                <div class="option"  @click="category='dragt'">Draft</div>
            </div>
        </div>
    </div>
    <div class="from">From :
        <input type="email" v-model="sender">
    </div>
   
    <div class="to">To  :
        <input type="email" v-model="receiver">

    </div>

    <div class="subject">Subject :
        <input type="text" v-model="subject">
    </div>    </div>

</template>
<script>
export default {

    data() {
        return {
            id: this.$route.params.id,
            subject:'',
            sender:'',
            receiver:'',
            category:'',
        }
    },
    methods: {
       handlesearch(){
        this.$emit('handlesearch',this.subject,this.sender,this.receiver,this.category);
       }
    },
}


</script>
<style scoped>
.dropdown {
  position: relative;
  display: inline-block;
}
.option {
    color: black;
  padding: 12px 16px;
  display: block;
  text-align: left;
}
.dropdown-content {
    display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
  border-radius: 10px;
  

}
 .dropdown:hover  {
    position: relative;
    box-shadow: none;
    background-color: #c8c8c8   ;

}
.dropdown{
    border-radius: 5px;
    color: black;
    padding: 10px 10px;
    border: 1px rgb(123, 121, 121) solid;
    background-color: #e6e6e6   ;

}
.dropdown:hover .dropdown-content {
  display: block;
}
.dropdown-content div:hover {background-color: #f1f1f1; 
    border-radius: 10px;
}
.searchcontainer {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    padding-top: 20px;
    padding-left: 5px;
}

</style>