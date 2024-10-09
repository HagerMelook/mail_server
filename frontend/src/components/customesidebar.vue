<template>
  <nav v-if="done">
    <div class="account">
      {{ username }}
    </div>
    <button id="create" @click="startcreate()"><img src="../assets/edit-svgrepo-com.svg"></button>
    <div>
      <img src="../assets/inbox-alt-svgrepo-com.svg">
      <router-link :to="{ name: 'inbox', params: { id: userId } }" id="f">Inbox</router-link>
    </div>
    <div>
      <img src="../assets/basic-sent-app-svgrepo-com.svg">
      <router-link :to="{ name: 'sent', params: { id: userId } }">Sent</router-link>
    </div>
    <div>
      <img src="../assets/draft-svgrepo-com.svg">
      <router-link :to="{ name: 'draft', params: { id: userId } }">Draft</router-link>
    </div>
    <div>
      <img src="..\assets\contacts-svgrepo-com.svg">
      <router-link :to="{ name: 'contact', params: { id: userId } }">Contacts</router-link>
    </div>
    <div>
      <img src="../assets/trash-blank-alt-svgrepo-com.svg">
      <router-link :to="{ name: 'trash', params: { id: userId } }">Trash</router-link>
    </div>
    <label v-if="folders.length">Folders</label>
    <div class="foldercontainer">
      <div v-if="folders" v-for="folder in folders">
        <img src="../assets/folder-svgrepo-com(1).svg">
        <router-link :to="{ name: 'folders', params: { id: userId, folderName: folder.name } }"> {{ folder.name }}</router-link>
        <button class="group" @click="deletefolder(folder.name)"><img src="../assets/trash-blank-alt-svgrepo-com.svg"></button>
      </div>
    </div>

  </nav>
</template>
<script>
import axios from 'axios';
export default {
  props: []
  ,
  data() {
    return {
      selectfolder: false,
      done: false,
      folders: [],
      userId: this.$route.params.id,
      username:'',
    }
  }
  , methods: {
    startcreate() {
      this.$emit('handlecreateemail', true);
    },
    deletefolder(name){
      axios.delete('http://localhost:8080/' + this.userId + '/userFolders/'+name+'/delete',
      )
      .catch((error) => {
        console.log(error)
        this.done = true
      });
    }
  },
  beforeMount() {
    //api to get folder 
    //done = true
    axios.get('http://localhost:8080/' + this.userId ,
    )
      .then((respond) => {
        this.username=respond.data;
      })
      .catch((error) => {
        console.log(error)
      });
    axios.get('http://localhost:8080/' + this.userId + '/userFolders',
    )
      .then((respond) => {
        console.log("folders" + respond.data);
        this.folders = respond.data;
        this.$emit('sendfolders', respond.data)
        this.done = true

      })
      .catch((error) => {
        console.log(error)
        this.done = true
      });

  }

}
</script>
<style scoped>
.account {
  text-align: left;
  font-size: x-large;
  font-weight: bold;
  padding-bottom: 30px;
}

button {
  border-radius: 20px;
  margin-bottom: 30px;
  margin-top: 10px;
  position: relative;
}

div {
  display: flex;
  flex-direction: row;
}

nav {
  padding: 30px;
  display: flex;
  flex-direction: column;
  text-align: left;
}

nav a {
  color: #2c3e50;
  text-decoration: none;
  padding: 15px 0;
}

nav a.router-link-exact-active {
  color: #42b983;
  font-weight: bold;

}

.folder {
  margin-bottom: 15px;
}

.foldercontainer {
  display: flex;
  flex-direction: column;
  overflow: scroll;
  height: 25vh;
}

img {
  width: 25px;
  margin-right: 10px;
  position: relative;
}

label {
  font-size: large;
  font-weight: bold;
  margin: 20px auto;
}
</style>
