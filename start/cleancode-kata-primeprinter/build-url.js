function buildUrl(url, options = {}) {
    let builtUrl = '';
  
    if (url === null) {
      builtUrl = '';
    } else if (typeof url === 'object') {
      options = url;
    } else {
      builtUrl = url;
    }
  
    if (options.path) {
      builtUrl += `/${options.path}`;
    }
  
    if (options.queryParams) {
      const queryString = Object.entries(options.queryParams)
        .map(([key, value]) => `${encodeURIComponent(key)}=${encodeURIComponent(value)}`)
        .join('&');
      if (queryString) {
        builtUrl += `?${queryString}`;
      }
    }
  
    if (options.hash) {
      builtUrl += `#${encodeURIComponent(options.hash)}`;
    }
  
    return builtUrl;
  }
