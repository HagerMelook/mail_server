<template>
    <div class="container">
        <input type="checkbox" id="check">
        <div class="login form">
            <header>Login</header>
            <form action="#">
                <input type="text" placeholder="Enter your email" v-model="email">
                <input type="password" placeholder="Enter your password" v-model="password">
                <div class="error" v-if="formErrors">{{ formErrors[0] }}</div>
                <input type="button" class="button" value="Login" v-on:click.prevent="login">

            </form>
            <div class="signup">
                <span class="signup">Don't have an account?
                    <label for="check" @click="restarterrors()">Signup</label>
                </span>
            </div>
        </div>
        <div class="registration form">
            <header>Signup</header>
            <form action="#" target="_parent">
                <input type="name" placeholder="Enter your name" v-model="name">
                <input type="text" placeholder="Enter your email" v-model="email">
                <input type="password" placeholder="Create a password" v-model="password">
                <input type="password" placeholder="Confirm your password" v-model="configpassward">
                <div class="error" v-if="formErrors">{{ formErrors[0] }}</div>
                <input type="button" class="button" value="Signup" @click="sign">

            </form>
            <div class="signup">
                <span class="signup">Already have an account?
                    <label for="check" @click="restarterrors()">Login</label>
                </span>
            </div>
        </div>
    </div>
</template>
<script>
import router from '@/router';
import axios from 'axios'
export default {
    data() {
        return {
            configpassward: '',
            password: '',
            name: '',
            email: '',
            maxChar: 10,
            formErrors: [],
            respond: '',
            routerReady: false
        }
    },
    methods: {
        //       
        restarterrors(){
            this.formErrors=[]
        },  
        emailValidation(email) {
            var validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

            if (this.email.match(validRegex)) {
                return true
            }
            return false
        },
        sign(e) {
            this.formErrors = [];
            if (this.email && !this.emailValidation()) {
                this.formErrors.push("Please, Enter A Valid Email")
            }
            if (!this.email) {
                this.formErrors.push("Email Can Not Be Empty")
            }
            if (!this.name) {
                this.formErrors.push("Name Can Not Be Empty")
            }
            if (!this.password) {
                this.formErrors.push("Password Can Not Be Empty")
            }
            if (this.password && this.password.length < this.maxChar) {
                this.formErrors.push("Password must be more than " + this.maxChar + " characters")
            }
            if (this.password !== this.configpassward) {
                this.formErrors.push("password confirmation don't match your password")
            }
            if (!this.formErrors.length) {
                const data = {
                    username: this.name,
                    email: this.email,
                    password: this.password
                }
                axios.post('http://localhost:8080/register',
                    data,
                    {
                        headers: {
                            "Content-Type": 'application/json'
                        }
                    }
                )
                    .then((respond) => {
                        console.log(respond.data);
                        this.routerReady = true
                        if (this.routerReady && !this.formErrors.length) {
                            this.$router.push({
                               name: 'inbox',
                               params:{ id :respond.data }
                            });
                        }
                    })
                    .catch((error) => {
                        this.formErrors.push("This account already exists");
                        this.name = ''
                        this.password = ''
                        this.configpassward = ''
                        this.email = ''
                    });

            }

        },
        login(e) {
            this.formErrors = [];
            if (this.email && !this.emailValidation()) {
                this.formErrors.push("Please, Enter A Valid Email")
            }           
            if (this.password && this.password.length < this.maxChar) {
                this.formErrors.push("Password must be more than " + this.maxChar + " characters")
            }
            if (!this.formErrors.length) {
                const data = {
                    email: this.email,
                    password: this.password
                }
                axios.post('http://localhost:8080/login',
                    data,
                    {
                        headers: {
                            "Content-Type": 'application/json'
                        }
                    }
                )
                    .then((respond) => {
                        console.log(typeof(respond.data));
                        this.routerReady = true
                        if (this.routerReady && !this.formErrors.length) {
                            this.$router.push({
                               name: 'inbox',
                               params:{ id :respond.data }
                            });
                        }
                    })
                    .catch((error) => {
                        if(error.response.status === 401){
                            this.formErrors.push("Invalid email or password");
                            this.password = ''
                            this.email = ''

                        }
                        else if(error.response.status === 400)
                        {
                            this.formErrors.push("Username and password are required for login.");

                        }
                       
                    });

            }

        }
    }
}
</script>
<style scoped>
/* Import Google font - Poppins */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

.container {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    max-width: 430px;
    width: 100%;
    background: #fff;
    border-radius: 7px;
    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.3);
}

.form .error {
    color: #7c2323;
    text-align: left;
}

.container .registration {
    display: none;
}

#check:checked~.registration {
    display: block;
}

#check:checked~.login {
    display: none;
}

#check {
    display: none;
}

.container .form {
    padding: 2rem;
}

.form header {
    font-size: 2rem;
    font-weight: 500;
    text-align: center;
    margin-bottom: 1.5rem;
}

.form input {
    height: 60px;
    width: 100%;
    padding: 0 15px;
    font-size: 17px;
    margin-bottom: 1.3rem;
    border: 1px solid #ddd;
    border-radius: 6px;
    outline: none;
}

.form input:focus {
    box-shadow: 0 1px 0 rgba(0, 0, 0, 0.2);
}

.form a {
    font-size: 16px;
    color: #009579;
    text-decoration: none;
}

.form a:hover {
    text-decoration: underline;
}

.form input.button {
    color: #fff;
    background: #009579;
    font-size: 1.2rem;
    font-weight: 500;
    letter-spacing: 1px;
    margin-top: 1.7rem;
    cursor: pointer;
    transition: 0.4s;
}

.form input.button:hover {
    background: #006653;
}

.signup {
    font-size: 17px;
    text-align: center;
}

.signup label {
    color: #009579;
    cursor: pointer;
}

.signup label:hover {
    text-decoration: underline;
}
</style>