import Layout from "./components/Layout";
import MainPage from "./pages/MainPage";
import {Route,Link,Routes,Router, BrowserRouter} from 'react-router-dom';
import AuthPage from "./pages/AuthPage";
import AddPage from "./pages/AddPage";
import {useState} from "react";


function App() {
    let [user,setUser]=useState({idUser:0,login:"",pass:"",email:""})
    let [s,se]=useState({})
  return (
      <BrowserRouter>
              <Routes>
                  <div></div>
                  <Route exact path="/" element={<AuthPage createUser={setUser}/>} >
                  </Route>
                  <Route exact path="/mainPage" element={<MainPage user={user}/>}>
                  </Route>
                  <Route exact path="/add" element={<AddPage/>}>
                  </Route>
              </Routes>
      </BrowserRouter>
  );
}

export default App;
