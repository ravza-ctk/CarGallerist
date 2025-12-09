import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  
  
  if (req.url.includes('/register') || req.url.includes('/authenticate')) {
    return next(req);
  }

  const token = localStorage.getItem('accessToken');

  if (token) {
    const clonedRequest = req.clone({
      headers: req.headers.set('Authorization', 'Bearer ' + token)
    });
    return next(clonedRequest);
  }

  return next(req);
};