<template>
    <div class="emailcontainer">
        <h3 class="newmessage">New Contact</h3>
        <br>
        <form id="email-form">
            <label for="email">Name:</label>
            <input type="text" id="name" placeholder="Enter the Name" required v-model="name">
            <br>
            <label for="email">Email:</label>
            <input type="email" id="name" placeholder="Enter the Email" required v-model="email">
            <br>
            <button type="submit" @click="handlecreate()">Save</button>
        </form>
    </div>
</template>
<script>
import axios from 'axios';
export default {

    data() {
        return {
            name: '',
            email: '',
            id: this.$route.params.id,
        }
    },
    methods: {
        handlecreate() {
            const data = {
                "name": this.name,
                "email": this.email
            }
            axios.post('http://localhost:8080/' + this.id + '/contacts/add',
                data
            )
                .catch((error) => {
                    console.log(error)
                });

            this.$emit('handlenewfolder');
        },
    },
}


</script>
<style scoped>
h3 {
    margin-left: 20px;
}

img {
    padding-top: 10px;
    width: 20px;
    margin-right: 5px;

}

.emailcontainer {
    overflow: scroll;
    height: 75vh;
    border-radius: 20px;
    width: 800px;
    padding: 0 15px;
    margin: 0 auto;
    overflow-x: h;
}

.file {
    margin-left: 30px;
    color: #000000;
    background: #ffffff;
    font-size: 1.2rem;
    font-weight: 500;
    letter-spacing: 1px;
    cursor: pointer;
    transition: 0.4s;
    padding: 5px 5px;
    font-size: medium;
    border-radius: 20px;
    ;
}

.file:hover {
    background: #dcdddc;
}

input,
textarea {
    width: 100%;
    padding: 10px;
    border: none;
    border-bottom: 1px solid #CCCCCC;
    margin-bottom: 12px;
    box-sizing: border-box;
}


button[type="submit"] {
    background-color: #4CAF44;
    color: white;
    padding: 10px 18px;
    border: none;
    cursor: pointer;
    border-radius: 20px;
    margin-right: 10px;
}

button[type="submit"]:hover {
    background-color: #45a045;
}
</style>
    