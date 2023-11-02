import Time_table from "./Component/Time_table";
import {Routes,Route} from "react-router-dom"
import Navbar from "./Component/Navbar";
import Login from "./Component/Login";
function App() {
 return(
    <div className="App">
           <Navbar/>
           <Routes>
            <Route path="/" element={<Time_table/>}/>
            <Route path="/Login" element={<Login/>}/>
           </Routes>
      </div>
  );
}

export default App;
