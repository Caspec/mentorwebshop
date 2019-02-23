<template>
<div>
    <div class="containerLogin">
        <table>
            <tr>
                <td><label>Brugernavn</label></td><td><input class="input" type="text" name="user_name" placeholder="username" v-model="user_name"></td><td></td>
            </tr>
            <tr>
                <td><label>Password</label></td><td><input class="input" type="text" name="user_password" placeholder="password" v-model="user_password"></td><td></td>
            </tr>
            <tr>
                <td></td><td><button class="button" name="login" @click="login" type="submit">Login to Admin</button></td><td></td>
            </tr>
        </table>
    </div>
</div>
</template>

<script>
export default {
    data(){
        return {
            user_name: '',
            user_password: ''
        }
    },
    methods: {
        login(){
         this.$http.post('http://localhost:3001/login', { user_name: this.user_name, user_password: this.user_password })
        .then ((res) => console.log(res))
        .catch ((error) => console.log(error))
    }
    }
}
</script>

<style>
.containerLogin {
margin-top: 5em;
}
.input {
    padding: 15px 32px;
    margin: 4px 2px;
    width: 100%;
}
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 24px;
  margin: 10px 2px;
  cursor: pointer;
}
table {
    margin: 0 auto;
}
label {
    font-size: 20px;
}
</style>


