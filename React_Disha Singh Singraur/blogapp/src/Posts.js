import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to fetch posts');
        }
        return response.json();
      })
      .then(data => {
        const postList = data.map(item => new Post(item.id, item.title, item.body));
        this.setState({ posts: postList });
      })
      .catch(error => {
        this.setState({ error: error.message });
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert('Error: ' + error.message);
    this.setState({ error: error.message });
  }

  render() {
    if (this.state.error) {
      return <div>Error loading posts: {this.state.error}</div>;
    }
    return (
      <div>
        <h2>Posts</h2>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ borderBottom: '1px solid #ccc', margin: '10px 0', paddingBottom: '10px' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;