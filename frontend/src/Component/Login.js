import React, { useState } from 'react'
import "./Login.css"
import axios from 'axios'
import { Link } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
const notify = () => toast("LOGIN SUCCESSFULLY");
export default function Login() {
    const [info,setInfo]=useState({
        name:"",
        email:"",
        subject:""
    });
      const apply=(data)=>{
        setInfo({
            ...info,
            [data.target.name]: data.target.value
          });
      }
    const login=async()=>{
        
         const response=await axios.post("http://localhost:8080/mail/save/teacher",info)
        console.log(info.name)
        notify()
    }
  return (
    <div className='main_login'>
       <ToastContainer style={{marginTop:"100px"}}/>
        <div className='login_container'>
            <h1>Faculty Login</h1>
        <p className='title_input'>Name</p>
        <input type='text' name='name' placeholder='Name of the faculty' className='info' onChange={(data)=>{apply(data)}}/>
        <p className='title_input'>Email</p>
        <input type='text'name='email' placeholder='Email of faculty' className='info' onChange={(data)=>{apply(data)}}/> 
        <p className='title_input'>Subject</p>
        <input type='text' placeholder='Subject Handle' name='subject' className='info' onChange={(data)=>{apply(data)}}/>
        <button className='buttons_login' onClick={login}>Submit</button>
        <Link to="/"><button className='buttons_cancel'>Cancel</button></Link>
        </div>  
    </div>
  )
}
