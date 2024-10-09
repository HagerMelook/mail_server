<template>
    <div class="emailcontainer">
        <h3 class="newmessage">New Message</h3>
        <br>
        <form id="email-form">
            <label for="email">To:</label>
            <input type="email" id="email" placeholder="Enter email address" required v-model="email">
            <br>
            <label for="subject">Subject:</label>
            <input type="text" id="subject" placeholder="Enter the subject of the email" required v-model="subject">
            <br>
            <label for="message">Message:</label>
            <textarea id="message" placeholder="Enter your message" required v-model="text"></textarea>
            <br>
            <label for="ddlViewBy">Priority:</label>
            <select id="ddlViewBy">
                <option v-on:click="importance = 'high'">High</option>
                <option v-on:click="importance = 'medium'" selected="selected">Medium</option>
                <option v-on:click="importance = 'low'">Low</option>
            </select>
            <br>
            <div id="file-list">
                <h2>Files:</h2>
                <ul>
                    <li v-for="file in files" :key="file.fileName">
                        <span @click="openFile(file)" style="cursor: pointer;">{{ file.fileName }}</span>
                    </li>
                </ul>
            </div>
            <button type="submit" @click="sendmessage()">Send</button>
            <button type="submit" @click="savedraft()">Save as draft</button>

            <input type="file" @change="handleFileUpload(e)" />
            <button @click="uploadFile()">Upload</button>
            <label for="my-file" class="file" title="attach files"><img src="../assets/attach-svgrepo-com.svg"></label>
        </form>
    </div>
</template>
<script>
import axios from 'axios';
export default {

    data() {
        return {
            selectedFile: null,
            files: [],
            text: '',
            email: '',
            subject: '',
            importance: '',
            id: this.$route.params.id,
        }
    },
    methods: {
        handleFileUpload(e) {
            this.selectedFile = e.target.files;
        },
        uploadFile() {
            if (!this.selectedFile) {
                alert('Please select a file.');
                return;
            }
            // used to construct key/value pairs representing form fields and their values. hashmapشبه ال 
            const formData = new FormData();
            //the selected file is appended to the FormData object.key='file' and the file object is added with its name.
            formData.append('file', this.selectedFile, this.selectedFile.name);

            // const apiUrl = 'http://localhost:8080/api/upload';

            // fetch(apiUrl, {
            //     method: 'POST',
            //     body: formData,
            // })
            //     .then((response) => {
            //         if (!response.ok) {
            //             throw new Error(`HTTP error! Status: ${response.status}`);
            //         }


            //         console.log('File uploaded successfully!');

            //         this.loadFiles();
            //     })
            //     .catch((error) => {
            //         console.error('Error uploading file:', error.message);
            //     });
        },

        savedraft() {
            //api to save the message in draft
            const data = {
                receiver: this.email,
                subject: this.subject,
                text: this.text,
                importance:this.importance,
                sender:null

            }
            axios.post('http://localhost:8080/' +this.id +'/createEmail/save ',
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
                this.$emit('backtoemails');

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
                this.$emit('backtoemails');

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

.ddlViewBy {
    border-radius: 20%;
    padding: 4px 6px;
    background-color: #c0c1c0;
    color: white;
    font-size: small;

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
    