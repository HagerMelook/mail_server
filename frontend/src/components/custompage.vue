<template>
    <div class="viewcontainer">

        <customsidebar :username="username" v-on="console.log(usrname)" v-on:handlecreateemail="handlecreateemail"
            v-on:sendfolders="sendfolders"></customsidebar>

        <div class="container">
            <customsearchbar v-on:click="startsearch = true, check = false"></customsearchbar>
            <div class="alloptions">
                <label for="ddlViewBy" class="group"
                    v-if="!showemail && !startcreate && !startsearch && !newfolder && !contactview">Sort By:</label>
                <select id="ddlViewBy" class="group"
                    v-if="!showemail && !startcreate && !startsearch && !newfolder && !contactview">
                    <option value="1">Priority</option>
                    <option value="2" selected="selected">Date</option>
                </select>
                <button class="group" v-if="showemail || startcreate" @click="backtoemails()"><img
                        src="../assets/back-svgrepo-com.svg"></button>
                <!-- <button class="group" v-if="!showemail && !startcreate &&" @click="backtoemails()"><img
                        src="../assets/back-svgrepo-com.svg"></button> -->

                <button class="group" v-if="check || showemail" v-on:click="handledelete()"><img
                        src="../assets/trash-blank-alt-svgrepo-com.svg"></button>
                <button class="group" v-show="contactview" v-on:click="newcontact = true">+</button>

                <div class="dropdown group" v-if="(check || showemail) && !contactview">
                    <img src="../assets/move-to-folder-svgrepo-com.svg">
                    <div class="dropdown-content">
                        <div class="option" v-for="folder in folders"
                            v-on:click="folderselected = folder.id, selectfolder = true, sendtofolder()">
                            {{ folder.name }}
                        </div>
                        <div class="option" v-on:click="newfolder = true, check = false">Create new</div>
                    </div>
                </div>

                <pagination class="pagination" v-if="!showemail && !startcreate && !startsearch && !newfolder"
                    v-bind:emails="emails" v-on:page:update="updatepage" v-bind:currentPage="currentpage"
                    v-bind:pageSize="pagesize">
                </pagination>

                <customemailpage v-if="showemail" :email="emailshowed"></customemailpage>
                <customsearchpage v-else-if="startsearch" v-on:handlesearch="handlesearch"></customsearchpage>
                <customcreateemail v-else-if="startcreate" v-on:backtoemails="backtoemails"></customcreateemail>
                <customcreatfolder v-else-if="newfolder" v-on:handlenewfolder="handlenewfolder"></customcreatfolder>
                <customcreatcontact v-else-if="newcontact" v-on:handlenewfolder="handlenewfolder"></customcreatcontact>

                <div class="emails" v-if="!startcreate && !newfolder && !showemail && !contactview">
                    <div v-for="email in visibleemails">
                        <customemail :text="email.text" :date="email.date" :subject="email.subject" :sender="email.sender"
                            :receiver="email.receiver" :id="email.id" :inbox="inbox" :sent="sent"
                            :priority="email.importance" v-on:handlegroup="handlegroup" :check="check"
                            v-on:handleshowemail="handleshowemail"></customemail>
                    </div>
                </div>
                <div class="emails" v-if="contactview">
                    <div v-for="email in visibleemails">
                        <Customcontact :email="email.email" :name="email.name" :id="email.id" v-on:handlegroup="handlegroup"
                            :check="check"></Customcontact>
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>
    
<script>
import customsidebar from '../components/customesidebar.vue'
import customsearchbar from '../components/customsearchbar.vue'
import customsearchpage from '../components/customsearchpage.vue'
import customemail from '../components/customemail.vue'
import customemailpage from '../components/customemailpage.vue'
import customcreateemail from '../components/customcreateemail.vue'
import customcreatfolder from '../components/customcreatefolder.vue'
import customcreatcontact from '../components/customcreateconatact.vue'
import pagination from '../components/pagination.vue'
import { ref } from 'vue'
import Customcontact from './customcontact.vue'

export default {
    name: 'custompage',
    components: {
        customsidebar,
        customsearchbar,
        customemail,
        customcreateemail,
        customemailpage,
        pagination,
        customcreatfolder,
        customsearchpage,
        Customcontact,
        customcreatcontact
    },
    props: ['emails', 'contactview', 'sent', 'inbox', 'username'],
    data: function () {
        return {
            folders: [],
            newcontact: false,
            id: this.$route.params.id,
            startsearch: false,
            newfolder: false,
            startcreate: false,
            showemail: false,
            check: false,
            currentpage: 0,
            showemailid: 0,
            emailshowed: [],
            group: [],
            visibleemails: [],
            currentpage: 0,
            pagesize: 10,
            // error: '',
            // filter: 'all'
        }
    },
    methods: {
        sendfolders(folders) {
            this.folders = folders;
        },
        handlegroup(id, check) {
            if (check) {
                this.group.push(id);
                this.check = true;
            }
            else {
                const index = this.group.indexOf(id);
                this.group.splice(index, 1);
            }
            if (!this.group.length) {
                this.check = false
            }
            console.log(this.group);
        },
        handledelete() {
            this.group = this.group.sort();
            this.$emit('handledelete', this.group)
        },
        handleshowemail(id) {
            this.group = [];
            this.check = false;
            this.showemailid = id;
            this.showemail = true;
            for (let x in this.emails) {
                if (this.emails[x].id == this.showemailid) {
                    this.emailshowed = this.emails[x];

                }
            }
        },

        backtoemails() {
            this.showemail = false;
            this.startcreate = false;
        },
        handlecreateemail(choice) {
            this.group = [];
            this.check = false;
            this.startcreate = choice;
        },
        reload() {
            //api get all the emails again
            this.$emit("reload")
        },
        updatepage(pageNumber) {
            this.currentpage = pageNumber;
            this.updatevisibleemails();
        },
        updatevisibleemails() {
            this.visibleemails = this.emails.slice(this.currentpage * this.pagesize, (this.currentpage * this.pagesize) + this.pagesize);
            if (this.visibleemails.length == 0 && this.currentpage > 0) {
                this.updatepage(this.currentpage - 1);
            }

        },
        handlesearch() {
            //take parameters from search page and send it using api
            //save respond.data in emails 
        },
        sendtofolder() {
            //api to send id of the folder and the group if its length !=0
            //api to send id of the folder and the id of emailshowed
        },
        handlenewfolder() {
            this.newfolder = false;
            this.newcontact = false;
            //reload
        }
        //add email and update visible emails
        //while add update the pagination in the end
        //remove email and update visible emails
        //while add update the pagination in the end
        //delete 
        //update
        //to sort //    get the option    document.getElementById('ddlViewBy').value;
    },
    beforeMount: function () {
        this.updatevisibleemails();

    },

    mounted() {
    }

};
</script>
  
<style scoped>
/* copy this part to other pages */

.viewcontainer .container .emails {
    overflow: scroll;
    height: 75vh;
    border-radius: 20px;
}

.group {
    margin-bottom: 5px;
    margin-top: 15px;

}

.alloptions {
    background-color: white;
    border-radius: 20px;
    margin-right: 25px;


}

.pagination {
    display: inline;
    margin-left: 50%;
    position: relative;
}

button {
    position: relative;
    width: 40px;
    height: 40px;
    border-radius: 100%;
    box-shadow: none;
    border: none;
    background-color: transparent;
    margin: 10px 20px auto 40px;

}

input {

    margin: auto 0px auto 20px;
    width: 20px;
    height: 20px;
}

button:hover {
    background-color: rgb(202, 201, 201);
    cursor: pointer;


}

label {
    margin-left: 10px;
    margin-right: 10px;
}

img {
    width: 20px;
    margin: auto;
}

input {
    visibility: visible;
}

.ddlViewBy {
    border-radius: 20%;
    padding: 4px 6px;
    background-color: #c0c1c0;
    color: white;
    font-size: small;

}

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
    box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
    z-index: 1;
    border-radius: 10px;


}

.dropdown:hover {
    position: relative;
    border-radius: 100%;
    box-shadow: none;
    border: none;
    background-color: #c0c1c0;
}

.dropdown {
    padding: 10px 10px;

}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown-content div:hover {
    background-color: #f1f1f1;
    border-radius: 10px;
}</style>
  