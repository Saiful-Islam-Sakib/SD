//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Renaissance.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class Comment
    {
        public int commentId { get; set; }
        public int postId { get; set; }
        public int userId { get; set; }
        public Nullable<System.DateTime> creationDate { get; set; }
    }
}
