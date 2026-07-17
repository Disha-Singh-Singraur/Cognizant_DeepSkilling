import React, { useState } from 'react';
import { books, blogs, courses } from './data';

function BookDetails() {
  return (
    <div>
      <h1>Book Details</h1>
      {books.map(book => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <p>Price: Rs. {book.price}</p>
        </div>
      ))}
    </div>
  );
}

function BlogDetails() {
  return (
    <div className="v1">
      <h1>Blog Details</h1>
      {blogs.map(blog => (
        <div key={blog.id}>
          <h3>{blog.title}</h3>
          <p>{blog.body}</p>
        </div>
      ))}
    </div>
  );
}

function CourseDetails() {
  return (
    <div className="mystyle1">
      <h1>Course Details</h1>
      {courses.map(course => (
        <div key={course.id}>
          <h3>{course.cname}</h3>
        </div>
      ))}
    </div>
  );
}

function App() {
  const [view, setView] = useState('all');

  return (
    <div style={{ padding: '20px' }}>
      <div>
        <button onClick={() => setView('all')}>Show All</button>
        <button onClick={() => setView('books')}>Books Only</button>
        <button onClick={() => setView('blogs')}>Blogs Only</button>
        <button onClick={() => setView('courses')}>Courses Only</button>
      </div>
      <hr />
      {(view === 'all' || view === 'books') && <BookDetails />}
      {(view === 'all' || view === 'blogs') && <BlogDetails />}
      {(view === 'all' || view === 'courses') && <CourseDetails />}
    </div>
  );
}

export default App;