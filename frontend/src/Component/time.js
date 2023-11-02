import { message } from "antd";
import { useState,useEffect } from "react";
export default function Time(){
 const [time, setTime] = useState("");
useEffect(() => {
    const timerInterval = 1000;
    const recurringFunction = () => {
      const currentTime = new Date();
      const hours = currentTime.getHours();
      const minutes = currentTime.getMinutes();
      const seconds = currentTime.getSeconds();
      setTime(`${hours}:${minutes}:${seconds}`);
      setTimeout(recurringFunction, timerInterval);
    };
    recurringFunction();
    return () => {
      clearTimeout(timerInterval);
    };
  },[]);
  return time;
}
export function Day(){
    const [currentDay, setCurrentDay] = useState('');
    useEffect(() => {
        const date = new Date();
        const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        setCurrentDay(days[date.getDay()]);
        console.log(date.getDay())
      }, [])
      return currentDay;
}

