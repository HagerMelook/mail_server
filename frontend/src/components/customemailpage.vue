<template>
<div class="emailcontainer">

    <div class="subject">
        {{ email.subject }}
    </div>
    <div class="line">
        <div class="sender">
            {{ email.sender }}
        </div>
        <div class="date">
            {{ email.date }}
        </div>
        
    </div>
    <div class="message">
        {{ email.text }}
    </div>
</div>
</template>
<script>
export default {
    props: [
        'email'
    ],
    mounted(){
        console.log(this.email.sender);
    }

}

</script>
<style scoped>
.emailcontainer{
    overflow: scroll;
    height: 75vh;
    border-radius: 20px;
}
.subject{
    font-size:xx-large;
    margin-left: 30px;
    margin-bottom:30px;
    margin-top:10px;


}
.sender{
    font-weight: bold;
    margin-left: 20px;
    margin-bottom:30px;


}
.message{
    margin-left: 20px;
    padding-bottom: 30px;
    max-width: 100vb;
    overflow-wrap:break-word;
    overflow-y: scroll;
}
.line{
    display: grid;
    grid-template-columns: 7fr 1fr;
    }

</style>
