import request from '@/router/axios'

export function fetchList(query) {
  return request({
    url: '/fastdfs/sys/file/sysFilePage',
    method: 'get',
    params: query
  })
}

export function getObj(id) {
  return request({
    url: '/fastdfs/sys/file/' + id,
    method: 'get'
  })
}
