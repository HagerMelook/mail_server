<template>
    <div class="grid" >
        <input type="checkbox" id="check"  ref="theCheckbox" @click="handleclick()">
        <div class="sender td">
            {{ name }}
        </div>
        <div class="receiver td" >
           {{ email }}
        </div>
        
    </div>
</template>
<script>
export default {
    props: [
        'name',
        'email',
        'id'
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
    }

   
   
}

</script>
<style scoped>
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