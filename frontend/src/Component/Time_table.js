import axios from 'axios';
import React, { useState, useEffect } from 'react';
import "./Time.css"
let count=0;
function TimeDisplay({array}) {
      const [time, setTime] = useState(new Date());
    
  useEffect(() => {
    const intervalId = setInterval(() => {
      setTime(new Date());
    }, 1000);
    let timestring=time.toLocaleTimeString()
      if(timestring==="08:30:00"||timestring==="09:20:00"||timestring==="10:30:00"||timestring==="11:20:00"||timestring==="12:50:00"||timestring==="13:40:00"||timestring==="14:30:00"||timestring==="15:20:00"){
        const fetchData = async () => {
          try {
            const response = await axios.post(`http://localhost:8080/mail/get/${array[count].staffEmail}`);
            console.log("sent");
          } catch (error) {
            console.error("Error:", error);
          }
          console.log(array[count].staffEmail);
          count++;
        };
        fetchData();
      }
    return () => {
      clearInterval(intervalId);
    };
  }, [time]);
  return (
    <p>{time.toLocaleTimeString()}</p>
  );
}

function Time_table() {
  const array = [1, 2, 3, 4, 5, 6, 7, 8];
  const [pop, setPop] = useState(false);
  const [id, setId] = useState();
  const [subject, setSubject] = useState();
  const [email, setEmail] = useState();
  const [period, setPeriod] = useState();
  const [content2, setContent2] = useState([])
  const data2 = {
    "id": id,
    "email": email
  }
  const [content, setContent] = useState([]);
  
  console.log("hello")

  const change = (name, subject, email) => {
    setPop(!pop);
    setId(name);
    setSubject(subject);
    setEmail(email);
  };
  const update = async (e) => {
    e.preventDefault();
    change();
    const response = await axios.put("http://localhost:8080/mail/update", data2);
    const response2 = await axios.get("http://localhost:8080/mail/getValue2");
    setContent(response2.data);
    console.log(period)
  };
  const getAllData = async () => {
    try {
      const response = await axios.get("http://localhost:8080/mail/getValue2");
      const response2 = await axios.get("http://localhost:8080/mail/getValue");
      setContent(response.data);
      setContent2(response2.data);
    } catch (error) {
      console.error("Error:", error);
    }
  };

  useEffect(() => {
    getAllData();
  }, []);
  return (
    <div>
      <div className='title'>
    <h2><TimeDisplay array={content}/></h2>
      </div>

      <div className='table_container'>
        <table border={1} className='table'>
          <tr>
            {array.map((f) => (
              <th key={f}>{f}</th>
            ))}
          </tr>
          <tr>
            {content.map((data, index) => (
              <td key={index} onClick={() => change(data.name, data.subject, data.email)}>Faculty : {data.name}<br></br>Subject : {data.subject}</td>
            ))}
          </tr>
        </table>
      </div>
     
      {pop && (
        <div className='model'>
          <div className='overlay'></div>
          <div className='model_contain'>
            <h1>Change the period</h1>
            Period <input
              type='text'
              placeholder='for which period'
              onChange={(e) => setId(e.target.value)}
              className='periodinput'
            />
            email  <select className='emailinput' onChange={(e) => setEmail(e.target.value)}>
              <option>select email</option>
              {content2.map((data, index) => (
                <option key={index}  >{data.email}</option>
              ))}
            </select>
            <button onClick={change} className='login_button'>close</button>
            <button onClick={update} className='login_button2'>submit</button>
          </div>
        </div>

      )}
     
    </div>
  )
}


export default Time_table;
