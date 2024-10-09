<template>
    <div class="grid" v-on:dblclick="showemail()"  >
        <input type="checkbox" id="check"  ref="theCheckbox" @click="handleclick()">
        <div class="sender td" v-if="inbox">
            {{ sender }}
        </div>
        <div class="receiver td" v-if="sent">
           To : {{ receiver }}
        </div>
        <div class="message td">
            <span> {{subject}}</span> - {{ text }}
        </div>
        <div class="date td">
            {{ date }}
        </div>
        <!-- <div class="options">
            <button><img src="../assets/trash-blank-alt-svgrepo-com.svg"></button>
        </div> -->
        
    </div>
    <hr id="level">
</template>
<script>
export default {
    props: [
        'sent',
        'inbox',
        'text',
        'date',
        'sender',
        'receiver',
        'id',
        'subject',
        'priority',
    ],
    
    methods: {
        handleclick() {
            if (this.$refs.theCheckbox.checked){
                this.$emit('handlegroup',this.id,true);
            }
            else{
                this.$emit('handlegroup',this.id,false);
            }
        },
        showemail(){
            this.$emit('handleshowemail',this.id)
            //this.$router.push({name: 'email',   params:{ id : this.id } });
        },
       
    },


    mounted(){
            if(this.priority ==="medium" ){
                document.getElementById("level").style.color = "yellow";
            }
            else if(this.priority ==="high" ){
                document.getElementById("level").style.color = "red";
            }
            else {
                document.getElementById("level").style.color = "green";
            }       
    }
   
}

</script>
<style scoped>
hr{
    width:99%;
    margin-top: -2px;
}
.grid {
    display: grid;
    grid-template-columns: max-content 1.25fr 5fr max-content ;
    overflow: hidden;
    border-bottom: 1px solid #ddd;
    background-color: white;
    padding: 8px 0 8px 10px;
    margin: 1px 4px 1px 0;
    
}

.grid .options {
    display: flex;
    flex-direction: row;
    margin-right: 5px;
}

.sender {
    font-weight: bold;
}
span{
    font-weight: bold;
}
.grid .td {
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    margin: 5px 0;
    padding-left: 10px;
}

input {
    margin: auto;
    width: fit-content;
    height: fit-content;
}

.grid:hover {
    background-color: #f1efef;
    box-shadow: 0 1px 5px rgba(0, 0, 0, 0.3);
    cursor: pointer;
}

button:hover {
    background-color: rgb(202, 201, 201);
    cursor: pointer;


}

img {
    width: 18px;
    margin: auto;
}

button {
    width: 40px;
    height: 40px;
    border-radius: 100%;
    box-shadow: none;
    border: none;
    background-color: transparent;
    margin-left: 4px;
}

.grid .date {
    font-size: small;
    margin-right: 10px;
}
</style>