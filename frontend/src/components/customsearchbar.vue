<template>
    <div class="searchbar">
        <input type="text" id="text" placeholder="Search">
        <button value="search"><img src="../assets/search-svgrepo-com.svg"></button>
    </div>
   
</template>
<style scoped>

input {
    width: 80%;
    font-size: 17px;
    box-shadow: none;
    outline: none;
    margin-right:30px;
    border: 1px solid #ffffff;

}
.searchbar{
    display: flex;
    flex-direction: row;
    margin-bottom: 1.3rem;
    margin-top: 20px;
    outline: none;
    padding: 0 15px;
    height: 50px;
    width: 50%;
    background-color: white;
    border: 1px solid #ffffff;
    border-radius: 20px;
}


.searchbar img {
  width: 25px;
  margin-right: 10px;
}
button{
    width: 40px;
    height:40px;
    border-radius: 100%;
    box-shadow: none;
    border:none;
    background-color: transparent;
    margin:auto auto;
    
}
button:hover{
    background-color: rgb(236, 236, 238);
    cursor: pointer;
}
</style>