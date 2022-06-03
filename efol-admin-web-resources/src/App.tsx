import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { library } from '@fortawesome/fontawesome-svg-core'
import { fab } from '@fortawesome/free-brands-svg-icons'
import { faCheckSquare, faCoffee, faP } from '@fortawesome/free-solid-svg-icons'
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import Fols from './pages/Fols';
import Equipments from './pages/Equipments';
import Keywords from './pages/Keywords';
import Home from './pages/Home';
import Categories from './pages/Categories';

library.add(fab, faCheckSquare, faCoffee)

export default function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Routes>
        <Route path="/home" element={<Home />} />
          <Route path="/fols" element={<Fols />} />
          <Route path='/equipments' element={<Equipments />} />
          <Route path='/categories' element={<Categories />} />
          <Route path='/keywords' element={<Keywords />} />
        </Routes>
      </Router>
    </>
  );
}
